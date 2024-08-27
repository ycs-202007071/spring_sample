package com.example.test1.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.example.test1.model.User;

@Mapper
public interface UserMapper {

	User selectUserInfo(HashMap<String, Object> map);
	
	void insertUser(HashMap<String, Object> map);

}
