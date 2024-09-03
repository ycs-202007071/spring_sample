package com.example.test1.dao;

import java.util.HashMap;

public interface AreaService {
	// 지역 목록 호출
	HashMap<String,Object> searchAreaList(HashMap<String,Object> map);
	
}
