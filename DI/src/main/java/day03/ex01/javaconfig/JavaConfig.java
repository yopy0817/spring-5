package day03.ex01.javaconfig;
//XML파일을 자바로 설정하기

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import day01.SpringTest;
import day02.ex01.construct.Chef;
import day02.ex01.construct.Hotel;
import day02.ex01.construct.ResTaurant;
import day02.ex02.setter.DatabaseDev;
import day02.ex03.battery.ApToy;
import day02.ex03.battery.Battery1;
import day02.ex03.battery.Battery2;
import day02.ex03.battery.CarToy;

//해당 어노테이션은 이클래스가, 스프링의 설정 bean이라는 것을 표기합니다
@Configuration
public class JavaConfig {
	
	//@bean이 붙은 메서드를 스프링컨테이너 bean처럼 사용합니다
	
	//day01
	//<bean id="good" class="test01.SpringTest"/>
	@Bean
	public SpringTest good() {
		return new SpringTest();
	}
	
	//day02
	//<bean id="chef" class="day02.ex01.construct.Chef" />
	@Bean
	public Chef chef() {
		return new Chef();
	}
	//<bean id="hotel" class="day02.ex01.construct.Hotel">
	@Bean
	public Hotel hotel() {
		//Hotel은 생성자로 Chef객체를 받기 때문에 매개값으로 chef()함수를 주입합니다.
		return new Hotel(chef()); 
	}
	@Bean
	public DatabaseDev DBdev() {
		//setter를 통해 값을 받고 있기 때문에 객체를 생성하고 세터 지정후 반환합니다.
		DatabaseDev dv = new DatabaseDev();
		dv.setUrl("jdbc:mysql://localhost:3306/test");
		dv.setUid("jsp");
		dv.setUpw("jsp");
		return dv;
	}
	
	//Quiz
	//restaurant객체를 bean으로 생성하세요.
	@Bean
	public ResTaurant rs() {
		return new ResTaurant(chef());
	}
		
	//배터리, Toy객체를 자바코드 Bean으로 생성하세요.
	@Bean
	public Battery1 bt1() {
		return new Battery1();
	}
	
	@Bean
	public Battery2 bt2() {
		return new Battery2();
	}
	
	//ApToy는 생성자로 만들어짐
	@Bean
	public ApToy apToy() {
		return new ApToy(bt1());
	}
	//CarToy는 세터로 만들어짐
	@Bean
	public CarToy carToy() {
		
		CarToy cal = new CarToy();
		cal.setBattery(bt2());
		return cal;
	}
	
	
	
	
	
}
