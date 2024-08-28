package com.example.test1.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.test1.model.Board;
import com.example.test1.model.User;

@Mapper
public interface UserMapper {

	User selectUserInfo(HashMap<String, Object> map);
	
	void insertUser(HashMap<String, Object> map);
	
	List<User> selectUserList(HashMap<String, Object> map);
	
	List<Board> selectBoardListUser(HashMap<String, Object> map);
	
	void deleteUserId(HashMap<String, Object> map);
	
	User selectUser(HashMap<String, Object> map);

}
