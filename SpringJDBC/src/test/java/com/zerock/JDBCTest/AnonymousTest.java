package com.zerock.JDBCTest;

import org.junit.Test;


interface Car {
	public void run();
}

public class AnonymousTest {
	
		@Test
		public void good() {
	
		Car car = new Car() {
			
			@Override
			public void run() {
				System.out.println("끼릭끼릭~!");
			}
		};
		
		//보통의 경우 구현하는 별도의 클래스를 생성해서 사용하지만
		//재사용할 일이없다면 익명클래스(이름없는 클래스) 로 선언하여 1회성으로 사용 할 수 있습니다.
		car.run(); //오버라이드 된 메서드 실행
		
		
		
		//-----------------------------------------------------------
		
		DB.query(new Car() {
			
			@Override
			public void run() {
				
				System.out.println("오버라이딩된 메서드 실행");
			}
		});
		
	}
}
class DB {
	
	static void query(Car car) {
		car.run();
		System.out.println("여기서는 전달받은 Car객체로 SQL문을 처리하는겁니다");
	};
}

