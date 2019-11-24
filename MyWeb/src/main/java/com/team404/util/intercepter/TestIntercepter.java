package com.team404.util.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TestIntercepter extends HandlerInterceptorAdapter{

	//1. 스프링에서 제공하는 HandlerInterceptorAdapter 클래스를 상속 받습니다.
	//2. alt + shift + s -> overriding method를 통해 3가지 메서드를 오버라이딩 해서 사용합니다.

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		
		if(user_id == null) {
			response.sendRedirect("loginPage"); //현재경로에서 참조 or 절대경로
			return false; //return false의 의미는 핸들러메서드를 실행후 Controller를 수행하지 않음
		} else {
			return true; //return true의 의미는 핸들러메서드를 실행후 Controller를 수행한다는 의미
		}

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

	
	
}
