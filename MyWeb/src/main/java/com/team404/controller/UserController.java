package com.team404.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team404.command.UserVO;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value= "/userJoin", method = RequestMethod.GET)
	public String join() {
		
		return "user/userJoin";
	}
	
	//restController가 아니라면 ResponsedBody 어노테이션을 붙여서 
	@RequestMapping(value = "/idConfirm")
	@ResponseBody
	public int idConfirm(@RequestBody UserVO vo) {
		
		System.out.println(vo.getId());
		
		return 1;
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
