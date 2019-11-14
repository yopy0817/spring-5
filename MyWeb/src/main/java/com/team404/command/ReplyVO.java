package com.team404.command;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ReplyVO {

	private int rno;
	private int bno;
	
	private String reply; //내용
	private String replyId; //작성자
	private String replyPw; //비밀번호
	private Timestamp replydate; //작성일
	private Timestamp updatedate; //수정일
}
