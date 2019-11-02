package configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import day01.SpringTest;
import day02.ex01.construct.Hotel;
import day02.ex01.construct.ResTaurant;
import day02.ex03.battery.ApToy;
import day02.ex03.battery.CarToy;

public class MainClass {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(JavaConfig.class);
		
		SpringTest t = ctx.getBean("good", SpringTest.class);
		t.method1();
		t.method2();
				
		Hotel h = ctx.getBean("hotel", Hotel.class);
		h.getChef().cook();

		
		//퀴즈
		ResTaurant r = ctx.getBean("rs", ResTaurant.class);
		r.getChef().cook();

		//퀴즈
		ApToy ap = ctx.getBean("apToy", ApToy.class);
		ap.button();

		CarToy car = ctx.getBean("carToy", CarToy.class);
		car.button();
		
		
	}
}
