package com.team404.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team404.service.memberService;

@Controller
@RequestMapping("/session/*")
public class SessionController {
//0. pom.xml에 AspectJ weaver추가
//	<dependency>
//		<groupId>org.aspectj</groupId>
//		<artifactId>aspectjweaver</artifactId>
//		<version>${org.aspectj-version}</version>
//	</dependency>
	
	@Autowired
	@Qualifier("mem123") //강제연결
	private memberService mem;
	//--------------------------세션, 인터셉터------------------------
	
	//1.main화면처리
	@RequestMapping("/mainPage")
	public String mainPage() {
		return "session/mainPage";
	}
	
	//2.로그인 페이지 화면처리
	@RequestMapping(value="/loginPage", method=RequestMethod.GET)
	public String loginPage() {
		
		return "session/loginPage";
	}
	//3.마이 페이지 화면처리
	@RequestMapping(value="/myPage", method=RequestMethod.GET)
	public String myPage(HttpSession session) {
		//8. 마이페이지 접근 막기
		//8. 세션 아이디가 없다면 접근할 수 없도록 메인 페이지로 이동(인터셉터 생성후 주석)
//		if(session.getAttribute("user_id") == null) {
//			return "redirect:/session/loginPage"; 
//		}
		
		return "session/myPage";
	}
	//3.정보 수정 페이지
	@RequestMapping(value="/updatePage", method=RequestMethod.GET)
	public String updatePage() {
		//9. 모든 페이지에 세션 검사를 하는 불편함이 생긴다(처리하지 않으면 주소를 통해 강제 접근이 가능함)
		return "session/updatePage";
	}
	
	//4.로그인 폼 처리
	@RequestMapping("/loginForm")
	public String sessionLogin(@RequestParam("id") String id, @RequestParam("pw") String pw,
			HttpSession session,
			RedirectAttributes RA) {

		//5.아이디가 abc, 비밀번호가 1234 라면 로그인 성공이라 가정
		if(id.equals("admin") && pw.equals("1234")) {
			session.setAttribute("user_id", id); //세션에 아이디 저장
			session.setAttribute("user_name", "관리자"); //세션에 이름 저장
			return "/session/myPage";
		}
		//6. 아이디 비밀번호가 틀렸을 때 다시 로그인 화면으로 보내고 싶은 경우
		else {
			//9. 리다이렉트를 보내면서 1회성 데이터로 파라미터값을 전달하고 싶을때 사용
			RA.addFlashAttribute("msg", "아이디 비밀번호를 확인하실래요??");
			return "redirect:/session/loginPage"; //다시 로그인 페이지로
		}
		
	}
	//7.로그 아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		
		session.removeAttribute("user_id"); //특정 세션 삭제
		session.invalidate(); //전체 삭제
		
		return "redirect:/session/mainPage"; 
	}

	
	//--------------------------AOP--------------------------------

	//2.join 화면처리
	@RequestMapping("/joinPage")
	public String joinPage() {
		return "session/joinPage";
	}
	//3.join 폼 처리
	@RequestMapping("/joinForm")
	public String joinForm(
				@RequestParam("id") String id,
				@RequestParam("pw") String pw,
				@RequestParam("name") String name,
				@RequestParam("email") String email	) { 
		
		mem.memberJoin(id, pw, name, email); //화면의 id 서비스로 전달
		
		return "redirect:/session/mainPage";
	}
	
	
	
}
