package day02.ex08.autowired.quiz;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Computer {
	@Autowired
	@Qualifier("mouse")
	private Mouse mouse;
	@Autowired
	@Qualifier("keyboard")
	private Keyboard kb;
	@Resource(name="monitor")
	private Monitor monitor;
	
	public void computerInfo() {
		System.out.println("***컴퓨터 정보***");
		mouse.info();
		kb.info();
		monitor.info();
	}
	
	
	
	
	
	
	
	
}
