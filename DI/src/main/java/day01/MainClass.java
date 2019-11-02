package day01;

import java.util.HashMap;
import java.util.HashSet;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("application-context.xml");
		
		
		 SpringTest test = ctx.getBean(SpringTest.class);
		 test.method1();
		 test.method2();
		 test.method3();

	}
}
