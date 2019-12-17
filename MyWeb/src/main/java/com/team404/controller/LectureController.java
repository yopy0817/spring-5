package com.team404.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team404.command.UserVO;
import com.team404.user.service.UserService;

@Controller
@RequestMapping("/lecture")
public class LectureController {
	
	//유저정보
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@RequestMapping("/java")
	public String javaMain(HttpSession session, Model model) {
		if(session.getAttribute("user_id") != null) {
			String user_id = (String)session.getAttribute("user_id");
			UserVO userVO = userService.userInfo(user_id);
			model.addAttribute("userVO", userVO);
		}
		return "lecture/java";
	}
	
	@RequestMapping("/java/${value}")
	public String java(HttpSession session, @PathVariable("value") String value, Model model) {
		
		if(session.getAttribute("user_id") != null) {
			String user_id = (String)session.getAttribute("user_id");
			UserVO userVO = userService.userInfo(user_id);
			model.addAttribute("userVO", userVO);
		}
		return "lecture/java/" + value;
	}
}
