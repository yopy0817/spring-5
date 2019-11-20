package com.team404.user.mapper;

import com.team404.command.UserVO;

public interface UserMapper {

	public int idConfirm(UserVO vo); //중복체크
	public int join(UserVO vo); //회원가입
	public int login(UserVO vo); //로그인
	public UserVO userInfo(String userId); //유저정보
}