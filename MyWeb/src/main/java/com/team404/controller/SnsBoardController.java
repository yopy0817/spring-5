package com.team404.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.header.Header;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.team404.command.SnsBoardVO;
import com.team404.command.UserVO;
import com.team404.snsboard.service.SnsBoardService;
import com.team404.user.service.UserService;

@Controller
@RequestMapping("/snsBoard")
public class SnsBoardController {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("snsBoardService")
	private SnsBoardService snsBoardService;
	
	//화면처리
	//화면에 넘어갈때 데이터를 전달하는 방법은 2가지입니다.
	//1. 화면진입시 DB에서 정보를 조회해서 모델로전달
	//2. jsp페이지에서 자바스크립트를 이용해서 페이지 로드후 비동기통신으로 처리하는방법
	@RequestMapping("/snsList")
	public String snsList(HttpSession session, Model model) {
		
		if(session.getAttribute("user_id") != null) {
			String user_id = (String)session.getAttribute("user_id");
			UserVO userVO = userService.userInfo(user_id);
			model.addAttribute("userVO", userVO);
		}
		
		return "snsBoard/snsList";
	}
	
	
	@RequestMapping("/upload")
	@ResponseBody
	public String upload(@RequestParam("file") MultipartFile file,
						 @RequestParam("content") String content,
						 HttpSession session) {
		
		try {
			String writer = (String)session.getAttribute("user_id"); //작성자
			
			//날짜별폴더생성
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Date date = new Date();
			String fileLoca = sdf.format(date);
			//저장할폴더
			String uploadPath = "C:\\Users\\Park\\Desktop\\spring\\upload\\" + fileLoca;
			//String uploadFolder = "D:\\jsp\\upload\\" + fileLoca;
						
			File folder = new File(uploadPath); //날짜별 파일생성
			//File folder = new File("D:\\jsp\\upload\\" + fileLoca); //날짜별 파일생성
			if(!folder.exists()) {
				folder.mkdir();
			}

			//서버에서 저장 할 파일 이름
			String fileRealName = file.getOriginalFilename(); // 파일 정보
			Long size = file.getSize(); //파일사이즈
			
			//파일명
			UUID uuid = UUID.randomUUID();
			String uuids = uuid.toString().replaceAll("-", "");
			System.out.println(uuids);
			
			//확장자
			String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."), fileRealName.length());

			System.out.println("저장할폴더:" + uploadPath);
			System.out.println("실제파일명 : " + fileRealName);
			System.out.println("사이즈 : " + size);
			System.out.println("폴더명:" + fileLoca);
			System.out.println("확장자 : " + fileExtension);
			System.out.println("uuid명:" + uuids);
			
			String fileName = uuids + fileExtension;
			System.out.println("변경해서저장할파일명:" + fileName);
			
			File saveFile = new File(uploadPath + "\\" + fileName);
			file.transferTo(saveFile); //스프링의 실제 파일 저장 메서드(FileWriter작업을 손쉽게 한방에 처리해준다)
			
			//서비스단에서 DB에 insert작업
			SnsBoardVO vo = new SnsBoardVO(0, writer, uploadPath, fileLoca, fileName, fileRealName, content, null);
			boolean result = snsBoardService.insert(vo);
			
			if(result) {
				return "success";
			} else {
				return "fail";
			}
 			
		} catch (Exception e) {
			System.out.println("업로드중 에러발생:" + e.getMessage());
			return "fail"; //에러시에도 실패를 반환한다
		}
	}
	//비동기통신후 가져올 목록
	@RequestMapping("/getList")
	@ResponseBody
	public ArrayList<SnsBoardVO> getList() {
		
		ArrayList<SnsBoardVO> list = snsBoardService.getList();
				
		return list;
	}

//	//1st	
//	@RequestMapping("/display")
//	@ResponseBody
//	public byte[] getFile(@RequestParam("fileLoca") String fileLoca,
//						  @RequestParam("fileName")String fileName) {
//
//		System.out.println("fileName: " + fileName);
//		System.out.println("fileLoca: " + fileLoca);
//		File file = new File("C:\\Users\\Park\\Desktop\\spring\\upload\\" + fileLoca + "\\" + fileName);
//		//File file = new File("D:\\jsp\\upload\\" + fileLoca + "\\" + fileName);
//		System.out.println("file: " + file);
//
//		byte[] result = null;
//		try {
//			//스프링의 파일데이터를 읽어서 바이트배열형으로 리턴하는 메서드 (매개변수로 File타입을 받는다)
//			result = FileCopyUtils.copyToByteArray(file); 
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
	
	//2nd
	@RequestMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]> getFile(@RequestParam("fileLoca") String fileLoca,
										  @RequestParam("fileName")String fileName) {
		
		System.out.println("fileName: " + fileName);
		System.out.println("fileLoca: " + fileLoca);
		File file = new File("C:\\Users\\Park\\Desktop\\spring\\upload\\" + fileLoca + "\\" + fileName);
		//File file = new File("D:\\jsp\\upload\\" + fileLoca + "\\" + fileName);
		System.out.println("file: " + file);
		
		
		ResponseEntity<byte[]> result = null;
		try {
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", Files.probeContentType(file.toPath()) );

			//ResponseEntity<>(바디에담을내용, 헤더에담을 내용, 상태메세지)
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//상세보기 처리
	@RequestMapping("/getDetail/{bno}")
	@ResponseBody
	public SnsBoardVO getDetail(@PathVariable("bno") int bno) {
		
		SnsBoardVO vo = snsBoardService.getDetail(bno);
		return vo;
	}
	
	//삭제처리
	@RequestMapping("/delete/{bno}")
	@ResponseBody
	public String delete(@PathVariable("bno") int bno, HttpSession session) {
		
		SnsBoardVO vo = snsBoardService.getDetail(bno); //게시물정보얻기
		if(session.getAttribute("user_id") == null || !session.getAttribute("user_id").equals(vo.getWriter()) ) {
			return "noAuth"; //작성자와 글쓴이가 맞지않으면 noAuth 리턴
		}
		
		boolean result = snsBoardService.delete(bno);//DB삭제메서드 실행
		if(result) {
			File file = new File(vo.getUploadPath() + "\\" + vo.getFileName());
			return file.delete() ? "success" : "fail"; //파일삭제 메서드
		} else {
			return "fail"; //DB삭제 실패시 fail리턴
		}
	}
	
	//다운로드 비동기처리(1.화면에서 클릭시 a태그를통해 download를 타도록 처리)
	@RequestMapping(value = "/download") //, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE
	@ResponseBody
	public ResponseEntity<byte[]> download(@RequestParam("fileLoca") String fileLoca,
											@RequestParam("fileName")String fileName) {
		File file = new File("C:\\Users\\Park\\Desktop\\spring\\upload\\" + fileLoca + "\\" + fileName);

		ResponseEntity<byte[]> result = null;
		try {
			//응답 본문을 브라우저가 어떻게 표시해야 할지 알려주는 헤더입니다. inline인 경우 웹페이지 화면에 표시되고, attachment인 경우 다운로드됩니다.
			//Content-Disposition: inline
			//Content-Disposition: attachment; filename='filename.csv'
			//파일명한글처리(Chrome browser) 크롬
			//header.add("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") );
			//파일명한글처리(Edge) 엣지 
			//header.add("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
			//파일명한글처리(Trident) IE
			//Header.add("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", " "));
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Disposition", "attachment; filename=" + fileName );
			
			byte[] fileCopy = FileCopyUtils.copyToByteArray(file); //해당경로의 파일의 바이트데이터를 읽는다
			result = new ResponseEntity<>(fileCopy, header, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return result;
		
		
		//헤더설정이 안되서 처리가 안됌
//		byte[] result = null;
//		try {
//			//스프링의 파일데이터를 읽어서 바이트배열형으로 리턴하는 메서드 (매개변수로 File타입을 받는다)
//			result = FileCopyUtils.copyToByteArray(file); 
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return result;
				
	}
	
}
