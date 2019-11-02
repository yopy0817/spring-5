package day02.ex07.autowired;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class Printer {
	/*
	Autowired - 타입으로 찾음 -> 이름으로 찾음
	-생성자, 속성값, 메서드 모두 적용이 가능하다
	-단 속성값이나, 메서드에 주입시 디폴트 생성자가 필요합니다.
	-왜??? 기본 생성자가 없다면 객체 생성 조차 되지 않기 때문이다
	
	Qualifier
	컨테이너에 동일 객체가 여러개 있을때 어느 객체를 주입할지 선택해주는 어노테이션
	@Autowired()
	@Qualifier("이름")
	*/

	//---------------------------------------------------
	@Autowired //됨
	@Qualifier("docu1")	//됨: 강제연결
	private Document doc;
	
	
	
	//@Autowired //됨
//	public printer(Document doc) {
//		this.doc = doc;
//	}
	
	public Document getDoc() {
		return doc;
	}
	
	@Autowired //됨
	@Qualifier("docu1")	//됨: 강제연결
	public void setDoc(Document doc) {
		this.doc = doc;
	}
	
	//----------------------빈이 여러개 일때--------------------
	//빈이 여러개 일 때는 생성자 주입은 구분 할 수 없습니다.
//	@Autowired		
//	@Qualifier("docu1")	//됨: 강제연결
//	private Document doc;
//	
//	public Document getDoc() {
//		return doc;
//	}
//	@Autowired	
//	@Qualifier("docu1") //됨: 강제연결
//	public void setDoc(Document doc) {
//		this.doc = doc;
//	}
}
