package com.team404.controllerTest;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team404.command.TestVO;

@RestController
@RequestMapping("/RestControl")
public class RestBasicController {
	
	//1. RestController는 기본적으로 return에 실린값이 리졸버로 전달되는 것이 아닌
	//   요청이 들어온 주소로 반환됩니다.
	//나 문자열 보낼게
	@RequestMapping(value = "/getText", produces = "text/plain; charset=utf-8")
	public String getText() {
		
		System.out.println(MediaType.TEXT_PLAIN_VALUE);
		
		return "안녕하세요";
	}
	

	//잭슨-데이터바인딩 다운
	//나 객체 보낼게! 다만,화면에서 객체를 어떻게 처리해야해? 잭슨-데이터바인딩이 모든화면에서 공용으로 사용되는 JSON형식으로 변환
	@RequestMapping(value = "/getObject") //, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public TestVO getObject() {
		
		return new TestVO(1, "홍길동", "kkk123");
	}
	
	//나 String받고, 컬렉션 보낼게!
	@RequestMapping("/getCollection")
	public ArrayList<TestVO> getCollection(@RequestParam("num") String num){
		System.out.println(num);
		
		ArrayList<TestVO> list = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			TestVO vo = new TestVO(i, "길자", "ggg");
			list.add(vo);
		}
		return list;
	}
	//나 getPath/값/값 으로 받고 Map으로 보낼게!
	@RequestMapping("/getPath/{id}/{pw}")
	public HashMap<String, TestVO> getPath(
			@PathVariable("id") String id, 
			@PathVariable("pw") String pw  ) {
		
		HashMap<String, TestVO> map = new HashMap<>();
		map.put("info", new TestVO(10, "길순", "hhh") );
		
		return map;
	}
	
	//JSON객체로 받고 TestVO에 값에 자동 맵핍 -> 그리고 list로 보낼게!
	//확인은 구글확장프로그램 Rest Client사용
	//http://localhost:8181/컨패스/RestControl/getJson
	//기본적으로 POST요청으로 내용을 바디에 숨겨 전송해야 하며
	//{"num": 1, "name": "홍길동", "id": "aaa123"}
	@RequestMapping("/getJson")
	public ArrayList<TestVO> getJson(@RequestBody TestVO vo) {
		
		ArrayList<TestVO> list = new ArrayList<TestVO>();
		
		return list;
	}
	
	
}
