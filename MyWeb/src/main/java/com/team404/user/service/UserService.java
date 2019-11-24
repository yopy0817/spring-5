package com.team404.user.service;

import com.team404.command.UserVO;

public interface UserService {

	public int idConfirm(UserVO vo);//아이디중복확인
	public int join(UserVO vo); //회원가입
	public int login(UserVO vo); //로그인
	public UserVO userInfo(String userId); //유저정보
	public int update(UserVO vo); //유저업데이트
	
}
