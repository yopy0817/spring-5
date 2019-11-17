package com.team404.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team404.command.UserVO;

@RestController
@RequestMapping("/ajax")
public class AjaxController {
	
	@RequestMapping(value = "/idConfirm")
	@ResponseBody
	public int idConfirm(@RequestBody UserVO vo) {
		
		System.out.println(vo.getUserId());
		
		return 1;
	}
	
}
