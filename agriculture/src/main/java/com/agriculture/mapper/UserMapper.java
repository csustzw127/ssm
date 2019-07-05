package com.agriculture.mapper;

import org.apache.ibatis.annotations.Param;

import com.agriculture.vo.User;

public interface UserMapper {

	User queryUserById(@Param("id")int id);
	
	void addUser(@Param("user") User user);
}
