package day02.ex07.autowired.quiz;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		//퀴즈입니다
		//1. autowiredQuiz-context.xml에 Monitor, Mouse, Keyboard, Computer 빈을 생성후, 
		//2. Computer 클래스에서 자동  주입하세요.
		//3. xml에서 빈을 얻은 후 computerInfo() 메서드를 실행하세요
	
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("autowiredQuiz-context.xml");
		
		Computer com = ctx.getBean(Computer.class);
		com.computerInfo();
		
	}
}
