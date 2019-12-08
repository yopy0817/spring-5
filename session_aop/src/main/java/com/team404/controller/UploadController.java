package com.team404.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/fileupload")
public class UploadController {

	@RequestMapping("/upload" )
	public void form() {
		
	}
	
	@RequestMapping( "/upload_ok" )
	public String upload(@RequestParam("file") MultipartFile file, Model model) {

		try {
			
			String fileRealName = file.getOriginalFilename(); // 파일 정보
			Long size = file.getSize(); //파일사이즈
			// 서버에서 저장 할 파일 이름
			String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."), fileRealName.length());
			String uploadFolder = "C:\\Users\\Park\\Desktop\\spring\\upload"; //저장할폴더
						
			System.out.println("fileRealName : " + fileRealName);
			System.out.println("size : " + size);
			System.out.println("fileExtension : " + fileExtension);

			File saveFile = new File(uploadFolder + "\\" + fileRealName);
			file.transferTo(saveFile); //실제 파일 저장 메서드(fileWriter작업을 손쉽게 한방에 처리해준다)
			
		} catch (Exception e) {
			System.out.println("업로드중 에러발생:" + e.getMessage());
		}
		
		return "fileupload/upload_ok";
	}
	
}
