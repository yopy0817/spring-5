package com.team404.util.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class UserIntercepter extends HandlerInterceptorAdapter{
	
	public void saveURI(HttpServletRequest request) {
		
		String uri = request.getRequestURI();
		System.out.println(uri); //요청정보를 받아옴
		String query = request.getQueryString();
		System.out.println(query); //매개값을 받아옴
		
		HttpSession session = request.getSession();
		session.setAttribute("uri", uri + "?" + query); //세션에 uri요청과 데이터값을 세션에 저장
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String user_id = (String)request.getSession().getAttribute("user_id");
		
		
		if(user_id == null) {
			saveURI(request); //기존의 정보를 메서드를 통해 저장해 놓고
			response.sendRedirect( request.getContextPath() + "/user/userLogin"); //로그인페이지로 유도
			return false; //컨트롤러 실행을 막음
		} else {
			return true; //컨트롤러 실행
		}
	}

	
	
}
