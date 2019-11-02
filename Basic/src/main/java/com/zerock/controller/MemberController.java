package com.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	//화면요청처리
	@RequestMapping("/login_ex01")
	public String login_ex01() {
		
		return "member/login_ex01";
	}
	
	//로그인 요청 처리
	@RequestMapping("/login")
	public String login(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) {
		
		String url = "";
		if(id.equals("1234") && pw.equals("1234")) {
			url = "member/login_ex01_ok";
		} else {
			url = "redirect:/member/login_ex01";
			model.addAttribute("check", "사용자의 ID혹은 패스워드가 일치하지 않습니다.");
			
		}
		
		return url;
	}
	
	
	
}
