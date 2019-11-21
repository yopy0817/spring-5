package com.team404.user.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.team404.command.UserVO;
import com.team404.user.mapper.UserMapper;

@Repository("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int idConfirm(UserVO vo) {
		return userMapper.idConfirm(vo);
	}

	@Override
	public int join(UserVO vo) {
		return userMapper.join(vo);
	}

	@Override
	public int login(UserVO vo) {
		return userMapper.login(vo);
	}

	@Override
	public UserVO userInfo(String userId) {
		
		return userMapper.userInfo(userId);
	}

	@Override
	public int update(UserVO vo) {
		
		return userMapper.update(vo);
	}

}
