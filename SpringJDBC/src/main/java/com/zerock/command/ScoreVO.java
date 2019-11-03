package com.zerock.command;

public class ScoreVO {
	//추가
	int num;
	String name;
	String kor;
	String eng;
	String math;
	
	public ScoreVO() {}
	//변경
	public ScoreVO(int num, String name, String kor, String eng, String math) {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	//추가
	public int getNum() {
		return num;
	}
	//추가
	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKor() {
		return kor;
	}
	public void setKor(String kor) {
		this.kor = kor;
	}
	public String getEng() {
		return eng;
	}
	public void setEng(String eng) {
		this.eng = eng;
	}
	public String getMath() {
		return math;
	}
	public void setMath(String math) {
		this.math = math;
	}
	
	
}
