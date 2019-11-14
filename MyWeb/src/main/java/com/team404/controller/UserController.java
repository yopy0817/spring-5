package com.team404.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value= "/join", method = RequestMethod.GET)
	public String join() {
		
		return "user/join";
	}
	
	@RequestMapping(value= "/login", method = RequestMethod.GET)
	public String login() {
		
		return "user/login";
	}
	
	@RequestMapping(value= "/mypage", method = RequestMethod.GET)
	public String mypage() {
		
		return "user/mypage";
	}
	
	@RequestMapping(value= "/mypageCheck", method = RequestMethod.GET)
	public String mypageCheck() {
		
		return "user/mypageCheck";
	}
	
}
