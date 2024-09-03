package com.example.test1.dao;

import java.util.HashMap;
import java.util.List;

import com.example.test1.model.Board;

public interface TestService {
	
	List<Board> getTest(HashMap<String, Object> map);
}
