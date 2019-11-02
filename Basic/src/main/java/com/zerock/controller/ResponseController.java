package com.zerock.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zerock.command.ReqVO;

@Controller
@RequestMapping("/response/*")
public class ResponseController {
	//화면처리
	//String형 메서드의 경우 일반적으로 view폴더 아래의 jsp파일와 연동됩니다 (뷰 리졸버 확인)
	@RequestMapping(value="/res_ex01")
	public String res_ex01(HttpServletResponse response) {
		return "response/res_ex01";
		
	}
	
//--------------------------------------------------------------------------

	//model전달자
	//컨트롤러에서 생성된 데이터를 담아서 전달하는 바구니 입니다.
	//메서드의 매개변수로 Model을 지정하면 자동으로 저장하는 바구니를 생성해서 화면으로 전달합니다.
	@RequestMapping(value="/res_ex02")
	public String res_ex02(Model model) {

		model.addAttribute("servertime", new Date());
		model.addAttribute("name", "park");
		
		return "response/res_ex02";
	}
	//컨트롤러에서 생성된 데이터를 담고, 이동할 화면까지 지정하는 ModelAndView
	@RequestMapping(value="/res_ex03")
	public ModelAndView res_ex03() {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("servertime", new Date());
		mv.addObject("name", "kim");
		mv.setViewName("response/res_ex03");
		
		return mv; //모델을리턴합니다
	}
	
	//첫번쨰 화면에서 전달받은 파라미터를 화면에서 다시 사용할 경우(req + forward 인  @ModelAttribute("받을값")
	@RequestMapping(value="/res_ex04")
	public String res_ex04(@ModelAttribute("id") String id) {
		System.out.println(id);
		
		return "response/res_ex04";
	}
	
	//데이터를 보낼때, VO객체(커맨드 객체)를 만들어서 한번에 보낼수 있습니다
	//이때 객체 이름을 바꿔서 보내 줄 수 있습니다.
	//화면에서는 info로 바뀐 이름으로 값을 받아 처리할 수 있습니다.
	@RequestMapping("/res_ex05") //post방식만 가능
	public String test(@ModelAttribute("info") ReqVO vo) {
		System.out.println(vo.getId());
		System.out.println(vo.getName());
		return "response/res_ex05";
	}

//--------------------------------------------------------------------------	
	//Quiz
	//퀴즈화면처리
	@RequestMapping(value="/res_quiz01")
	public String res_quiz01() {
		return "response/res_quiz01";
	}
	//방법1(RequestParam방식)
//	@RequestMapping(value="/res_login")
//	public String res_param(@RequestParam("id") String id, 
//			@RequestParam("pw") String pw, 
//			Model model ) {
//		
//		model.addAttribute("id", id); //아이디를 모델에 추가
//		if(id.equals("kim12") && pw.equals("1234")) {
//			
//			return "response/res_quiz02";
//		} else {
//			return "response/res_quiz03";
//		}
//		
//	}
	//방법2(커맨드객체방식)
//	@RequestMapping(value="/res_login")
//	public String res_param(ReqVO vo, Model model) {
//		String id = vo.getId();
//		String pw = vo.getPw();
//		
//		model.addAttribute("id", id); //아이디를 모델에 추가
//		if(id.equals("kim12") && pw.equals("1234")) {
//			return "response/res_quiz02";
//		} else {
//			return "response/res_quiz03";
//		}
//	}
	//방법3(ModelAttribute방식)
	@RequestMapping(value="/res_login")
	public String res_param(@ModelAttribute("id") String id, @ModelAttribute("pw") String pw, RedirectAttributes RA) {
		
		
		if(id.equals("kim12") && pw.equals("1234")) {
			return "response/res_quiz02";
		} else {
			return "response/res_quiz03";
			//"redirect:/" 다시 컨트롤러를 타게함, 이때 화면에 값을 전달하고 싶다면 
			//RedirectAttribute객체의 addFlashAttribute를 이용함
			//model은 전달할 수 없음
			//RA.addFlashAttribute("msg", "아이디 비밀번호를 확인하세요");
			//return "redirect:/response/res_quiz01";
		}
	}
	
	
	
	//-------------------------redirect and RedirectAttribute-------------------
	
	//화면처리
	@RequestMapping("/res_redirect_login")
	public String res_redirect() {
		return "response/res_redirect_login";
	}
	
	@RequestMapping("login")
	public String login(@ModelAttribute("id") String id, @ModelAttribute("pw") String pw, RedirectAttributes RA) {
		
		if(id.equals(pw)) {
			return "response/res_redirect_ok"; //성공
		} else {
			//"redirect:/" 다시 컨트롤러를 타게함, 이때 화면에 값을 전달하고 싶다면 
			//RedirectAttribute객체의 addFlashAttribute를 이용함
			//model은 전달할 수 없음
			RA.addFlashAttribute("msg", "아이디 비밀번호를 확인하세요");
			return "redirect:/response/res_redirect_login"; 
		}
	}
	


		
		
	
	
	

	
	
	
	
	//JSON ,XML형식등 모든 타입을 다전달하는 ReponseEntity타입
	@RequestMapping(value="/res_ex06")
	public ResponseEntity<String> res_ex04() {
		
		String msg = "{\"name\": 홍길동, \"age\":20 }";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<String>(msg, header, HttpStatus.OK);
	}
	
}
