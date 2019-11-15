package com.team404.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value= "/userJoin", method = RequestMethod.GET)
	public String join() {
		
		return "user/userJoin";
	}
	
	@RequestMapping(value= "/userLogin", method = RequestMethod.GET)
	public String login() {
		
		return "user/userLogin";
	}
	
	@RequestMapping(value= "/userMypage", method = RequestMethod.GET)
	public String mypage() {
		
		return "user/userMypage";
	}
	
	@RequestMapping(value= "/userCheck", method = RequestMethod.GET)
	public String mypageCheck() {
		
		return "user/userCheck";
	}
	
}
