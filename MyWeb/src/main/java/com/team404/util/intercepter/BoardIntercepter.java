package com.team404.util.intercepter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class BoardIntercepter extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("보드인터셉터 탓어");
		
		String writer = request.getParameter("writer");
		String user_id = (String)request.getSession().getAttribute("user_id");
		
		System.out.println(writer);
		System.out.println(user_id);
		
		//화면단에서는 반드시 writer에 대한정보를 넘기도록 처리합니다
		//처리했다면 변경, 수정, 삭제에 대한 테스트 후
		//regist화면에 세션값으로 처리, modify화면에 작성자를 readonly처리
		
		if( writer != null && writer.equals(user_id)) {//작성자가 null이 아니고  세션값과 같다면 컨트롤러 실행
			return true;
		} else {
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write("<script>");
			response.getWriter().write("alert('권한이 없습니다');");
			response.getWriter().write("history.go(-1);");
			response.getWriter().write("</script>");
			return false;
		}
		
		
		
		
	}

	
}
