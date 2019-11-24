package com.team404.service;

import org.springframework.stereotype.Service;

@Service("mem123")
public class memberServiceImpl implements memberService {

	@Override
	public void memberJoin(String id, String pw, String name, String email) {
		
		System.out.println("여기는 서비스 계층!");
		
		//@AfterThrowing어노테이션 사용시 강제에러 발생
		id.charAt(0);
		pw.charAt(0);
		name.charAt(0);
		email.charAt(0);
		
	}

	
}
