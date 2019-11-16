package com.team404.command;

import lombok.Data;

@Data
public class UserVO {

	private String id;
	private String pw;
	private String name;
	private String phone;
	
	private String addrDetail;
	private String addrBasic;
	private String addrZipNum;
	
}
