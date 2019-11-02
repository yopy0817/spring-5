package day03.ex01.collection02;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("collection-context02.xml");
		ArrayList<String> list = (ArrayList<String>)ctx.getBean("myList");
		
		System.out.println(list.toString());
		list.add("안녕");
		list.add("안녕");
		list.add("안녕");
		System.out.println(list.toString());
		
		HashMap<String, String> map = (HashMap<String, String>)ctx.getBean("myMap");
		
		map.put("1", "안녕");
		map.put("2", "안녕");
		System.out.println(map.toString());
		
		
		
	}
}
