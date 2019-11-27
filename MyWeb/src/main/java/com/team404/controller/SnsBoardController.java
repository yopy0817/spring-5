package com.team404.controller;

import java.io.File;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/snsBoard")
public class SnsBoardController {
	
	//화면처리
	@RequestMapping("/snsList")
	public String snsList() {
		return "snsBoard/snsList";
	}
	
	@RequestMapping("/upload")
	@ResponseBody
	public String upload(@RequestParam("file") MultipartFile file,
						 @RequestParam("content") String content) {
		
		try {
			
			String originFilename = file.getOriginalFilename(); // 파일 정보
			Long size = file.getSize(); //파일사이즈
			// 서버에서 저장 할 파일 이름
			String saveFileName = originFilename.substring(originFilename.lastIndexOf("."), originFilename.length());
			String uploadFolder = "C:\\Users\\Park\\Desktop\\spring\\upload"; //저장할폴더
						
			System.out.println("originFilename : " + originFilename);
			System.out.println("size : " + size);
			System.out.println("saveFileName : " + saveFileName);

			File saveFile = new File(uploadFolder + "\\" + saveFileName);
			file.transferTo(saveFile); //실제 파일 저장 메서드(fileWriter작업을 손쉽게 한방에 처리해준다)
			
		} catch (Exception e) {
			System.out.println("업로드중 에러발생:" + e.getMessage());
		}
		
		return "1";
	}
}
