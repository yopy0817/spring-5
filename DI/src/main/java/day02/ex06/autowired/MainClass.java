package day02.ex06.autowired;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("autowired-context.xml");
		
		Printer p = ctx.getBean("printer", Printer.class);
		//System.out.println(p.getDoc().data[0]);
		
		for(int i = 0; i < p.getDoc().data.length; i++)
			System.out.println(p.getDoc().data[i]);
		
		
		System.out.println("----------------------------------");
		
		Printer2 p2 = ctx.getBean("printer2", Printer2.class);
		
		for(int i = 0; i < p2.getDoc().data.length; i++)
			System.out.println(p2.getDoc().data[i]);
		
		
		
		
	}
}
