package com.team404.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.team404.command.UserVO;
import com.team404.user.service.UserService;

@Controller
@RequestMapping("/snsBoard")
public class SnsBoardController {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
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
						 @RequestParam("content") String content) {
		
		try {
			
			//날짜별폴더생성
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Date date = new Date();
			String fileLoca = sdf.format(date);
			//File folder = new File("C:\\Users\\Park\\Desktop\\spring\\upload\\" + fileLoca); //날짜별 파일생성
			File folder = new File("D:\\jsp\\upload\\" + fileLoca); //날짜별 파일생성
			if(!folder.exists()) {
				folder.mkdir();
			}

			//서버에서 저장 할 파일 이름
			String originFileName = file.getOriginalFilename(); // 파일 정보
			Long size = file.getSize(); //파일사이즈
			
			//파일명
			UUID uuid = UUID.randomUUID();
			String fileName = uuid.toString().replaceAll("-", "");
			System.out.println(fileName);
			
			//확장자
			String fileExtension = originFileName.substring(originFileName.lastIndexOf("."), originFileName.length());

			//저장할폴더
			//String uploadFolder = "C:\\Users\\Park\\Desktop\\spring\\upload\\" + fileLoca;
			String uploadFolder = "D:\\jsp\\upload\\" + fileLoca;
			
			System.out.println("실제파일명 : " + originFileName);
			System.out.println("사이즈 : " + size);
			System.out.println("폴더명:" + fileLoca);
			System.out.println("확장자 : " + fileExtension);
			System.out.println("uuid명:" + fileName);
			
			String saveFileName = fileName + fileExtension;
			System.out.println("변경해서저장할파일명:" + saveFileName);
			
			
			File saveFile = new File(uploadFolder + "\\" + saveFileName);
			file.transferTo(saveFile); //실제 파일 저장 메서드(FileWriter작업을 손쉽게 한방에 처리해준다)
			
		} catch (Exception e) {
			System.out.println("업로드중 에러발생:" + e.getMessage());
		}
		
		return "1";
	}
	//1st	
	@RequestMapping("/display")
	@ResponseBody
	public byte[] getFile(@RequestParam("fileLoca") String fileLoca,
						  @RequestParam("fileName")String fileName) {

		System.out.println("fileName: " + fileName);
		System.out.println("fileLoca: " + fileLoca);
		//File file = new File("C:\\Users\\Park\\Desktop\\spring\\upload\\" + fileLoca + "\\" + fileName);
		File file = new File("D:\\jsp\\upload\\" + fileLoca + "\\" + fileName);
		System.out.println("file: " + file);

		byte[] result = null;
		try {
			//스프링의 파일데이터를 읽어서 바이트배열형으로 리턴하는 메서드 (매개변수로 File타입을 받는다)
			result = FileCopyUtils.copyToByteArray(file); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
//	//2nd
//	@RequestMapping("/display")
//	@ResponseBody
//	public ResponseEntity<byte[]> getFile(String fileName) {
//		
//		System.out.println("fileName: " + fileName);
//		File file = new File("C:\\Users\\Park\\Desktop\\spring\\upload\\" + fileName);
//		System.out.println("file: " + file);
//
//		ResponseEntity<byte[]> result = null;
//		try {
//			HttpHeaders header = new HttpHeaders();
//			header.add("Content-Type", Files.probeContentType(file.toPath()));
//			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return result;
//	}
	
	
}
