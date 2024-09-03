package com.example.test1.dao;

import java.util.HashMap;

public interface SchoolService {
	// 사용자 상세 정보
	HashMap<String, Object> searchSchoolList(HashMap<String, Object> map);
	
	//사용자 상세보기
	HashMap<String,Object> searchSchoolInfo(HashMap<String,Object> map);

	// 사용자 삭제
	HashMap<String,Object> removeSchool(HashMap<String,Object> map);
	
	// 사용자 등록
	HashMap<String,Object> addSchool(HashMap<String,Object> map);
}
