package com.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zerock.command.Quiz01VO;
import com.zerock.command.Quiz02VO;

//quiz:
//해당클래스를 어노테이션을 이용하여 컨트롤러의 역할을 할수 있게 처리하세요
@Controller
@RequestMapping("/quiz/*")
public class QuizController {
	//quiz01
	
	@RequestMapping("/quiz01") //화면맵핑
	public String quiz01() {
		System.out.println("탔어");
		return "quiz/quiz01";
	}
	//1st	
//	@RequestMapping(value="/sendBirth") //폼전송 맵핑	
//	public String sendBirth(Quiz01VO vo, Model model) {
//		
//		String birth = vo.getYear() + vo.getMonth() + vo.getDay();
//		System.out.println(birth);
//		
//		model.addAttribute("birth", vo);
//		
//		return "quiz/quiz01_ok";
//	} 
	
	//2nd
//	@RequestMapping(value="/sendBirth") //폼전송 맵핑 //Post형식만 가능 // 이름바꾸기	
//	public String sendBirth(@ModelAttribute("birth") Quiz01VO vo) {
//		
//		String birth = vo.getYear() + vo.getMonth() + vo.getDay();
//		System.out.println(birth);
//				
//		//null값이 들어올경우 화면 처리
//		if(vo.getYear().equals("") || vo.getDay().equals("")) {
//			return "redirect:/quiz/quiz01"; //다시 화면요청을 타게함
//			//return "quiz/quiz01"; //화면으로 감 but 리다이렉트와 주소 요청이 다르게동작함
//		}
//
//		return "quiz/quiz01_ok";
//	} 
	
	
	//quiz02------------------------------------------------------------------
	@RequestMapping("/quiz02") //화면처리
	public String quiz02() {
		return "quiz/quiz02";
	}
//	@RequestMapping("/join") //폼처리
//	public String join(@ModelAttribute("joinInfo") Quiz02VO vo) {
//		
//		return "quiz/quiz02_ok";
//	}

	@RequestMapping("/join")
	public String join(Quiz02VO vo, Model model) {
		model.addAttribute("joinInfo", vo);
		
		return "quiz/quiz02_ok";
	}
	
	//quiz03------------------------------------------------------------------
	@RequestMapping("/quiz03") //화면처리
	public String quiz03() {
		return "quiz/quiz03";
	}
	
	@RequestMapping("/join2")
	public String join2(@ModelAttribute("id") String id, 
			@RequestParam("pw") String pw,
			@RequestParam("pw_check") String pw_check,
			RedirectAttributes RA
			) {
		
		
		if(id.equals("") ) {
			RA.addFlashAttribute("msg", "아이디를 입력하세요");
			return "redirect:/quiz/quiz03";
		} else if(!pw.equals(pw_check)) {
			RA.addFlashAttribute("msg", "비밀번호를 확인하세요");
			return "redirect:/quiz/quiz03";
		} else {
			return "quiz/quiz03_ok";
		}
		
		
	}
	
	
	
}
