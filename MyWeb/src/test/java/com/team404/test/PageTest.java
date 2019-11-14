package com.team404.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.team404.testmapper.TestMapper;
import com.team404.util.Criteria;

//테스트를 하기위한 준비
//pom.xml의 Junit버전이 4.12, spring-test 라이브러리가 다운되어야 함
//RunWith 디스패처서블릿을 거치지 않고, 테스트 환경을 거칠수 있게 해준다
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/DB-context.xml")
public class PageTest {
	
	@Autowired
	private TestMapper mapper;
	
	@Test
	public void test() {
		
		System.out.println(mapper.getTime());
		System.out.println(mapper.getPaging());
		
		Criteria cri = new Criteria();
		cri.setSearchType("title");
		cri.setSearchName("");
		System.out.println(mapper.getList(cri));
	}
	
	
}
