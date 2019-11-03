package com.zerock.JDBCTest;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/DB-context.xml")
public class JdbcTemplateTest {
	//pom.xml에 spring-test 라이브러리 추가
	//Run As -> JUnitTest (@Test어노테이션으로 JUnit 사용가능)
	@Autowired(required = false)
	DataSource datasource;
	@Autowired(required = false)
	JdbcTemplate jdbcTemplate;
	
	@Test
	public void testTemplate() {
		try {
			Connection conn = datasource.getConnection();
			System.out.println(">>>>>>>>>>>>>>connection출력:" + conn);
			
			System.out.println(">>>>>>>>>>>>>>템플릿객체생성:" + jdbcTemplate);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
