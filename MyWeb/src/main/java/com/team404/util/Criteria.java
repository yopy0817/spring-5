package com.team404.util;

import lombok.Data;

@Data //게터세터 자동생성
public class Criteria {

	private int pageNum;
	private int amount;
	
	private String searchName;
	private String searchType;
		
	public Criteria() {
		this(1, 10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
}


