package com.team404.command;

import java.sql.Timestamp;

import lombok.Data;

//롬복 라이브러리 추가시 가장많이 사용되는 @Data 어노테이션
@Data
public class FreeBoardVO {
	
	private int bno;
	private String title;
	private String content;
	private String writer;
	private Timestamp regdate;
	private Timestamp updatedate;
	
}
