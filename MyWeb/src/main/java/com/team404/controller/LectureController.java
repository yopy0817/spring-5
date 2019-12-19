package com.team404.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team404.command.LectureListVO;
import com.team404.command.LectureVO;
import com.team404.command.UserVO;
import com.team404.lecture.service.LectureService;
import com.team404.user.service.UserService;

@Controller
@RequestMapping("/lecture")
public class LectureController {
	
	//유저정보
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	//강의정보
	@Autowired
	@Qualifier("lectureService")
	private LectureService lectureService;
	
	@RequestMapping("/{lecNo}/{lecListNo}")
	public void javaMain(HttpSession session, 
						   @PathVariable("lecNo") int lecNo, 
						   @PathVariable("lecListNo") int lecListNo,
						   Model model) {
		
		if(session.getAttribute("user_id") != null) {
			String user_id = (String)session.getAttribute("user_id");
			UserVO userVO = userService.userInfo(user_id);
			model.addAttribute("userVO", userVO);
		}

		//강의목록가져오기
		LectureVO lecVO = lectureService.getLectureList(lecNo); 
		model.addAttribute("lecVO", lecVO);
		
		LectureListVO lecListVO = lectureService.getDetail(lecListNo);
		model.addAttribute("lecListVO", lecListVO);
		
		System.out.println(lecVO.toString());

	}

}
