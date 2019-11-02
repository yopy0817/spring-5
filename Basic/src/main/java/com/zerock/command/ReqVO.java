package com.zerock.command;

public class ReqVO {
	//컨트롤러가 파라미터를 타입에 따라 자동으로 받아줌(int형으로 가능)
	//단 폼태그의 이름과 setter의 set을 제외한 이름이 같아야함
	private String id;
	private String pw;
	private String name;
	private String age; 
	private String phone1;
	private String phone2;
	private String phone3;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getPhone3() {
		return phone3;
	}
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
	
	
	
	
}
