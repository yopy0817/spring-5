package day02.ex03.battery;


import org.springframework.context.support.GenericXmlApplicationContext;


public class MainClass {

	public static void main(String[] args) {
		
		//퀴즈입니다
		//해당 클래스들을 이용하여 다음 결과를 낼 수 있도록 application-context에 빈을 생성하세요.
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("application-context.xml");
		
		ApToy ap = ctx.getBean("ApToy", ApToy.class);
		ap.button();
		
		CarToy car = ctx.getBean("CarToy", CarToy.class);
		car.getBattery().energy();
		
		
		
		
	}
}
