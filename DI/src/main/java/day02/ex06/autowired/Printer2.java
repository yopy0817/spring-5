package day02.ex06.autowired;

import javax.annotation.Resource;

public class Printer2 {
	/*
	Resource - 이름(id)로 찾음 -> 타입으로 찾음
	-속성값, 메서드에 적용가능하다 (생성자에 할 수 없다)
	
	Quealifier("이름") 또한 사용가능하다
	*/
	
	@Resource(name="docu2") //됨 (명시적으로 이름속성을 적어주는게 정석이다)
	private Document doc;
	
//	@Resource(name="docu") //안됨
//	public Printer2(Document doc) {
//		this.doc = doc;
//	}
	
	public Document getDoc() {
		return doc;
	}
	
//	@Resource(name="docu") //됨
	public void setDoc(Document doc) {
		this.doc = doc;
	}
	
	
	
}
