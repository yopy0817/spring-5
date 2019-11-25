package com.team404.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect //Aspect 클래스를 의미
@Component //bean 자동 생성명령(컴포넌트 스캔에 추가)
public class LogAdvice {
	
	private static final Logger log = LoggerFactory.getLogger(LogAdvice.class);
	
	/*
	//맨앞 *는 접근제한자를 의미 맨 뒤 *는 메서드를 의미
	@Before("execution(* com.team404.service.memberServiceImpl*.*(..))")
	//@Before("execution(* com.team404.controller.*Controller*.*(..))")
	public void beforeLog() {
		System.out.println("log:-------메서드 실행 전-------");
	}
	//이후 AOP설정!
	@After("execution(* com.team404.service.memberServiceImpl*.*(..)) && args(p1, p2, p3, p4)")
	public void afterLog(String p1, String p2, String p3, String p4) {
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
		System.out.println("log:-------메서드 실행 후-------");
	}
	//해당 어노테이션은 예외가 발생하면 동작합니다
	//pointcut-어떤메서드에 적용할것인가 //throwing-처리할 에러변수
	@AfterThrowing(pointcut="execution(* com.team404.service.memberService*.*(..))", throwing="e")
	public void errorLog(Exception e) {
		System.out.println("에러내용:" + e);
	}
	*/
	
	//이 모든것을 한번에 처리하는 강력한 기능 around
	//메서드 실행 권한을 가지고 , 실행 전, 실행 후 처리가 가능
	//@Around가 적용되는 메서드(어드바이스)는 반드시 리턴이 있어야 합니다.
	@Around("execution(* com.team404.service.memberServiceImpl.*(..))")
	public Object aroundLog(ProceedingJoinPoint jp) {
		long start = System.currentTimeMillis();
		//해당 기능을 통해 메서드 실행전 결과를 확인할 수 있습니다.
		//System.out.println("적용클래스:" + jp.getTarget());
		//System.out.println("적용파라미터:" + Arrays.toString(jp.getArgs())  );
		log.info("적용클래스:" + jp.getTarget());
		log.info("적용파리미터:" + Arrays.toString(jp.getArgs()) );
		
		Object result = null;
		
		try {
			//proceed()는 타겟 메서드를 지칭한다, 해당 메서드를 실행 시켜야 타겟이 되는 메서드가 실행된다
			//해당 메서드를 만나기 전까지 Before 어드바이스가 실행된다
			result = jp.proceed(); 
		} catch (Throwable e) {
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();
		//System.out.println("메서드수행에 걸린시간:" + (end - start) );
		log.info("메서드수행에걸린시간:" + (end - start));
		
		
		return result;  
	}

}
