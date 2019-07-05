package com.agriculture.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agriculture.mapper.UserMapper;
import com.agriculture.service.UserService;
import com.agriculture.vo.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	

	public boolean ajaxValidateLoginname(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean ajaxValidateEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	public void regist(User user) {
		// TODO Auto-generated method stub
		
	}

	public boolean active(String activecode) {
		// TODO Auto-generated method stub
		return false;
	}

	public User login(User user) {
		return userMapper.queryUserById(user.getId());
	}

}
