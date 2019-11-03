package com.zerock.JDBCTest;

import java.sql.*;

import org.junit.Test;

public class JdbcTest {
		/*
		create table board01(
		    b_num int primary key auto_increment,
			b_name varchar(30),
		    b_title varchar(30),
		    b_content varchar(50)
    	); 
		*/
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
		String uid = "spring"; 
		String upw = "spring"; 
		
		
		//src/test/java 폴더에는 자바클래스를 이용하여 여러 작업을 테스트할 용도로 사용합니다
		//Run As탭의 -> JUnitTest 으로 실행하며
		//@Test어노테이션이 붙은 메서드를 실행합니다.
		@Test
		public void JdbcTests() {
			try {
				//JDBC 드라이버 호출
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				Connection conn = DriverManager.getConnection(url, uid, upw);
				System.out.println(">>>>>connection객체생성:"+ conn);
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
				
		}
	}

