package com.example.test1.dao;

import java.util.HashMap;

public interface UserService {
	
	HashMap<String, Object> selectUserInfo(HashMap<String, Object> map);
	
	HashMap<String, Object> addUser(HashMap<String, Object> map);
	//사용자 목록
	HashMap<String, Object> searchUserList(HashMap<String, Object> map);
	
	HashMap<String, Object> searchBoardListUser(HashMap<String, Object> map);
	
	HashMap<String, Object> removeUser(HashMap<String, Object> map);
	// 게시글 상세보기
	HashMap<String,Object> searchUser(HashMap<String,Object> map);
	
}
