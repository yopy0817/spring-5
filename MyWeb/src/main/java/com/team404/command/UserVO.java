package com.team404.command;

import java.sql.Timestamp;
import java.util.ArrayList;

import lombok.Data;

@Data
public class UserVO {

	private String userId;
	private String userPw;
	private String userName;
	private String userNick;
	private String userPhone1;
	private String userPhone2;
	private String userEmail1;
	private String userEmail2;
	
	private String addrZipNum; //우편번호
	private String addrBasic;//기본주소
	private String addrDetail; //상세주소
		
	private Timestamp regDate; //등록일
	
	private ArrayList<FreeBoardVO> userBoardList;
	
}
