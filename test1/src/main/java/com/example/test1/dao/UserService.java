package com.example.test1.dao;

import java.util.HashMap;

public interface UserService {
	
	HashMap<String, Object> selectUserInfo(HashMap<String, Object> map);
	
	HashMap<String, Object> addUser(HashMap<String, Object> map);
}
