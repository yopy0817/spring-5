package com.zerock.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zerock.command.ReqVO;
//선행작업 conPath의 경로를 /로 설정

@Controller
@RequestMapping("/request") //request이라는 url요청은 모두 RequestController에서 처리합니다.
public class RequestController {
	
	//로그를 출력할 수 있는 기능입니다.
	private static final Logger log = LoggerFactory.getLogger(RequestController.class);
	
	//모든 요청은 컨트롤러로 향하기 때문에 메인화면을 처리할 컨트롤러를 작성합니다.
	//해당 메서드를 호출하고 싶다면 /request/req_ex01 으로 호출해야 합니다.
	//반환유형이 없다면 호출된 URL과 동일한 페이지로 연결시킵니다
//	@RequestMapping(value="/req_ex01")
//	public void req_ex01() {
//		
//		log.info("콘솔창 로그 확인 main...."); //로그 확인
//		//jsp화면의 이름만 입력하더라도 viewResolver설정에 의해 처리됩니다.
//	}
	
	
	@RequestMapping(value="/req_ex01")
	public String req_ex01() {
		
		log.info("콘솔창 로그 확인 main...."); //로그 확인
		return "request/req_ex01";
	}
	//RequestMapping의 method속성 설정
	@RequestMapping(value="/basic1", method= RequestMethod.GET)
	public void basic1() {

		System.out.println("basic1호출 성공(GET방식)");
	}
	
	@RequestMapping(value="/basic2", method= RequestMethod.POST)
	public void basic2() {
		System.out.println("basic2호출 성공(Post방식)");
	}
	//get, post방식을 둘다 처리하기
	@RequestMapping(value="/basic3", method= {RequestMethod.GET, RequestMethod.POST})
	public void basic3() {
		System.out.println("basic3호출 성공(GET방식, POST방식)");
	}
	//지정하지 않으면 자동으로 맵핑
	@RequestMapping("/basic4")
	public void basic4() {
		System.out.println("basic3호출 성공(알아서 맵핑)");
	}
	
	//동일 요청처리라면 맵핑을 하나로 처리할 수 있습니다.(단, 해당요청에 대한 화면처리는 경로를 정확히 파악후에 사용해야함)
//	@RequestMapping({"/basic1", "/basic2", "/basic3", "/basic4", "/req_ex01"})
//	public void view() {
//		System.out.println("호출성공");
//	}
	
	
	
	//--------------------------------요청 파라미터 받기-------------------------------

	//요청 파라미터 받기
	//req_ex02.jsp 화면처리
	@RequestMapping(value="/req_ex02")
	public String req_ex02() {
		
		return "request/req_ex02";
	}
	//전통적 방식의 파라미터 값 받기
	/*
	@RequestMapping("/param")
	public String param(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		System.out.println(id);
		System.out.println(pw);
		System.out.println(name);
		System.out.println(age);
		System.out.println(phone1 + "-" + phone2 + "-" + phone3);
		
		return "request/req_ex03";
	}
	*/
	
	/*
	//@RequestParam("name")을 통한 파라미터 받기
	@RequestMapping(value="/param")
	public String param(@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			@RequestParam("name") String name,
			@RequestParam("age") String goodAge) 
	{
		System.out.println(id);
		System.out.println(pw);
		System.out.println(name);
		System.out.println(goodAge);
		return "request/req_ex03";
	}
	*/
	
	
	//실무에서 가장많이 쓰이는 커맨드객체를 통한 파라미터값 받기
	@RequestMapping(value="/param")
	public String param(ReqVO vo) {
		
		System.out.println(vo.getId());
		System.out.println(vo.getPw());
		System.out.println(vo.getName());
		System.out.println(vo.getAge());
		System.out.println(vo.getPhone1());


		return "request/req_ex02_result";
	}
	
	@RequestMapping("/param2")
	public String param2( @RequestParam(value="interest", required = false, defaultValue = "") ArrayList<String> list) {
		
		//필수가 아닌 파라미터의 경우 required = false 속성을 지정해주면 된다.
		//필수가 아닌 파라미터일 경우 null값을 지정하게 되는데, defaultVlue = "" 를 이용해 기본값을 지정할 수 있습니다.
		System.out.println("-----checkbox받기------");
		System.out.println(list.toString());
		
		return "request/req_ex02_result";
	}
	
	
	//quiz
	//화면처리
	@RequestMapping("/req_quiz01")
	public String req_quiz01() {
		return "request/req_quiz01";
	}
	//form처리
	@RequestMapping(value="/login")
	public String login(@RequestParam("id") String id, @RequestParam("pw") String pw) {
		
		if(id.equals("abc123") && pw.equals("xxx123")) {
			return "request/req_quiz01_ok";
		} else {
			return "request/req_quiz01_no";
			//return "redirect:/request/req_quiz01";
		}
	}
	
	
	
	
	
	
	
	
}
