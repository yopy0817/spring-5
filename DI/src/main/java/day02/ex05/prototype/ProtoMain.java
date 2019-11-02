package day02.ex05.prototype;

import org.springframework.context.support.GenericXmlApplicationContext;

import day01.SpringTest;

public class ProtoMain {

	public static void main(String[] args) {
		
		//Person클래스를 bean으로 생성 (proto-context.xml)
		//이름은 홍길자, age 20으로 설정
		//main호출


		GenericXmlApplicationContext ctx 
		= new GenericXmlApplicationContext("application-context.xml");

		SpringTest test = ctx.getBean("good", SpringTest.class);
		SpringTest test1 = ctx.getBean("good", SpringTest.class);
			
		System.out.println("같은객체입니까?" + test.equals(test1));
		
		
		
		//생성된 객체가 같은 객체인지 확인 - bean의 scope="prototype" 후 확인 
		System.out.println("----------------------------------");
		
		GenericXmlApplicationContext ctxx = 
				new GenericXmlApplicationContext("protoCtx.xml");
		
		Person p1 = ctxx.getBean(Person.class);
		Person p2 = ctxx.getBean(Person.class);
		
		p2.setName("홍길자");
		System.out.println(p1.getName());
		System.out.println(p2.getName());
		
		System.out.println("같은객체입니까?" + p1.equals(p2));
		
	}
}
