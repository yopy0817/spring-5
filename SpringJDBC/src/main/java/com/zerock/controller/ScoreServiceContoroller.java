package com.zerock.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zerock.command.ScoreVO;
import com.zerock.service.*;
/*
create table score01(
    num number(10,0) CONSTRAINT score01_pk PRIMARY KEY,
    name varchar(30),
    kor varchar(30),
    eng varchar(30),
    math varchar(30)
);
create SEQUENCE score01_seq;
*/


@Controller
@RequestMapping("/service/*")
public class ScoreServiceContoroller {

//	ScoreService scoreService = new ScoreServiceImpl();
	
//	@Resource(name="scoreService")(이름)
//	ScoreService scoreService; //<beans:bean id="scoreService" class="com.zerock.service.ScoreServiceImpl"/>
	
	@Autowired //@Service로 주입(타입)
	ScoreService scoreService; //service패키지에 컴포넌트스캔 걸어야함
		
	
	//화면처리
	@RequestMapping(value="/1scoreRegister")
	public String score() {
		return "service/1scoreRegister";
	}
	//점수 등록 메서드
	@RequestMapping(value="/scoreForm")
	public String scoreForm(ScoreVO vo) {
		
		scoreService.scoreRegist(vo); //점수 등록 메서드

		return "service/2scoreResult"; //뷰리졸버의 view를 찾아 강제이동
	}
	
	@RequestMapping(value="/3scoreList")
	public String scoreList(Model model) {
		//점수 결과반환 메서드
		//메서드의 파라미터에 Model을 추가하여, model에 list를 싣어줌(화면에서 사용가능)
		ArrayList<ScoreVO> scoreList = scoreService.scoreReesult(); 
		model.addAttribute("scoreList", scoreList);
		
		return "service/3scoreList";
	}
	
	@RequestMapping(value="/scoreDelete")
	public String scoreDelete(@RequestParam("num") String num) {
		
		scoreService.scoreDelete(num); //점수 삭제 메서드
		
		//return "service/3scoreList"; //이렇게 화면으로 넘겨주면 list의 값을 가져갈 수 없음
		return "redirect:3scoreList"; //★다시 컨트롤러를 탈수 있는 강제이동 redirect:
		
	}

	
}
