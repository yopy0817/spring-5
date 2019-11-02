package day03.ex01.collection;

import java.util.List;
import java.util.Map;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("collection-context.xml");
		
		Customer cus = (Customer)ctx.getBean("cus");
		
		//스트링타입 리스트
		System.out.println(cus.getLists().toString());
		
		
		//객체타입 리스트
		List<MemberVO> list = cus.getVo();
		
		for(MemberVO vo : list) {
			System.out.println(vo.getId());
			System.out.println(vo.getName());
		}
		
		System.out.println("------------------------------------");
		//맵 가져오기
		Map<String, Object> map = cus.getMaps();
		
		String s1 = (String)map.get("k1");
		System.out.println("이름:" + s1);
		
		MemberVO vo = (MemberVO)map.get("k2");
		System.out.println("vo아이디:" + vo.getId());
		System.out.println("vo이름:" + vo.getName());
		
		
		
		
		
	}
}
