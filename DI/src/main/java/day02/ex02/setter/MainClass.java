package day02.ex02.setter;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("application-context.xml");
		
		DatabaseDev dev = ctx.getBean("DBdev", DatabaseDev.class);
		System.out.println(dev.getUrl());
		System.out.println(dev.getUid());
		System.out.println(dev.getUpw());
		
		System.out.println("------------------------------------");
		//해당 클래스를 사용할 수 있도록 빈 주입 시키세요
		//url = "jdbc:mysql://118.130.22.132:3306/dev";
		//id = "auth01";
		//pw = "1234";
		
		//동일 클래스로 생성되었다면 이름으로 식별해서 가져와야 합니다.
		DatabaseDev dev2 = ctx.getBean("DBdev2", DatabaseDev.class);
		System.out.println(dev2.getUrl());
		System.out.println(dev2.getUid());
		System.out.println(dev2.getUpw());
		
		
		System.out.println("------------------------------------");
		//setter에 빈 주입		
		MemberDAO dao = ctx.getBean("ds", MemberDAO.class);
		dao.info();
		
		
		
	}
}
