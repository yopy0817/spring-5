package day02.ex07.autowired.quiz2;


import org.springframework.context.support.GenericXmlApplicationContext;


public class MainClass {

	public static void main(String[] args) {
		//quiz
		//1. 해당 패키지의 클래스를 다음 결과를 낼 수 있도록 applicationQuiz-context에 빈을 생성하세요.
		//2. ApToy, CarToy에선 의존객체 자동주입 하세요
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("applicationQuiz-context.xml");
		
		ApToy ap = ctx.getBean("ApToy", ApToy.class);
		ap.button();
		
		CarToy car = ctx.getBean("CarToy", CarToy.class);
		car.getBattery().energy();
		
		
		
		
	}
}
