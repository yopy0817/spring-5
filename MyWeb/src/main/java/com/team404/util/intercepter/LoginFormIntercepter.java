package com.team404.util.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginFormIntercepter extends HandlerInterceptorAdapter{

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		//로그인 처리후 핸들러
		String uri = (String)request.getSession().getAttribute("uri"); 
		System.out.println("유알아이는:" + uri);

		String user_id = (String)request.getSession().getAttribute("user_id");
		
		if(uri != null && user_id != null) { //기존 접근하려는 유알아이가 있는경우 유알아이로 이동
			response.sendRedirect(uri);
		
		} else if(user_id != null) { //일반적인 로그인 성공의 경우 메인화면으로 이동
			response.sendRedirect(request.getContextPath());	
		} 
		//아이디 비밀번호가 틀린경우는 기존의 컨트롤러대로 이동
		
	}

}







