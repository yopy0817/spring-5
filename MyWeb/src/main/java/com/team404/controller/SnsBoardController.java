package com.team404.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/snsBoard")
public class SnsBoardController {
	
	//화면처리
	@RequestMapping("/snsList")
	public String snsList() {
		return "snsBoard/snsList";
	}
}
