package com.zerock.JDBCTest;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/DB-context.xml")
public class MyBatisTest {

	@Autowired
	SqlSessionFactory sqlFactory;
	
	@Test
	public void testFactory() {
		
		System.out.println(">>>>>>>>>>>>>>sqlFactory출력:" + sqlFactory);
	}
}
