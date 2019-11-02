package day02.ex01.construct;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		Chef c = new Chef();
		Hotel h1 = new Hotel(c);
		h1.getChef().cook();
		
		//스프링 설정파일(Bean 사용)
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("application-context.xml");
		
		Hotel h = ctx.getBean("hotel", Hotel.class);
		h.getChef().cook();
		
		ResTaurant r = ctx.getBean("restaurant", ResTaurant.class);
		r.getChef().cook();
		
	}
}
