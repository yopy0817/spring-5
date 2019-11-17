package com.team404.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team404.command.UserVO;
import com.team404.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	//조인화면처리
	@RequestMapping(value= "/userJoin", method = RequestMethod.GET)
	public String join() {
		
		return "user/userJoin";
	}
	//로그인화면처리
	@RequestMapping(value= "/userLogin", method = RequestMethod.GET)
	public String login() {
		
		return "user/userLogin";
	}
	//마이페이지화면처리
	@RequestMapping(value= "/userMypage", method = RequestMethod.GET)
	public String mypage() {
		
		return "user/userMypage";
	}
	//유저체크화면처리
	@RequestMapping(value= "/userCheck", method = RequestMethod.GET)
	public String mypageCheck() {
		
		return "user/userCheck";
	}

	//일반 컨트롤러에서 @ResponseBody어노테이션을 적어주면 메소드의 리턴값은 view리졸버로가지 않고
	//해당메서드를 호출한 곳으로 결과를 반환합니다.
	@RequestMapping(value = "/idConfirm")
	@ResponseBody
	public int idConfirm(@RequestBody UserVO vo) {

		int result = userService.idConfirm(vo);
		return result;
	}
	//회원가입요청
	@RequestMapping("/joinForm")
	public String joinForm(UserVO vo, RedirectAttributes RA) {
		System.out.println(vo.toString());
		int result = userService.join(vo);
		
		if(result == 1) {
			RA.addFlashAttribute("msg", "회원가입에 성공했습니다");
		} else {
			RA.addFlashAttribute("msg", "회원가입에 실패했습니다");
		}
		//리다이렉트시 전달해줄 값은 RedirectAttributes객체를 이용합니다
		return "redirect:/user/userLogin";
		
	}
	
	//로그인처리요청
	@RequestMapping("/loginForm")
	public String loginForm(UserVO vo, RedirectAttributes RA, HttpSession session) {
		
		int result = userService.login(vo);
		
		if(result == 1) { //1개의 카운트가 나왔다는 것은 로그인 성공
			session.setAttribute("user_id", vo.getUserId() ); //세션에 아이디 저장
			return "redirect:/"; //홈화면으로 
		} else { //로그인 실패
			RA.addFlashAttribute("msg", "아이디 비밀번호를 확인하세요"); //1회성 데이터에 msg저장
			return "redirect:/user/userLogin";
		}
	}
	
}
