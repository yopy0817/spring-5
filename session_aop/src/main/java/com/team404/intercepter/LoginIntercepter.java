package com.team404.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginIntercepter extends HandlerInterceptorAdapter{
	//1. 스프링에서 제공하는 HandlerInterceptorAdapter 클래스를 상속 받습니다.
	//2. alt + shift + s -> overriding method를 통해 3가지 메서드를 오버라이딩 해서 사용합니다.
	
	
	//preHandle 메서드는 컨트롤러를 실행하기전 요청을 가로채 처리합니다.
	//일반적으로 로그인, 세션 처리에 사용됩니다.
	//preHandle에 세션 처리를 했다면 스프링 설정파일에 <interceptors> 태그를 이용해 맵핑 설정을 합니다.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		
		if(user_id == null) {
			response.sendRedirect("/OBJ/session/loginPage");
			return false;
			//return false의 의미는 핸들러메서드를 실행후 Controller를 수행하지 않음
		} else {
			return true; 
			//return true의 의미는 핸들러메서드를 실행후 Controller를 수행한다는 의미
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
