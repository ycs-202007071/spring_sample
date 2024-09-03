package com.example.test1.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.test1.model.School;

@Mapper
public interface SchoolMapper {
	List<School> selectSchoolList(HashMap<String, Object> map);
	
	// 상세보기
	School selectSchoolInfo(HashMap<String, Object> map);
	
	// 삭제
	void deleteSchool(HashMap<String, Object> map);
	
	//등록
	void insertSchool(HashMap<String, Object> map);
	
	int selectSchoolCnt(HashMap<String, Object> map);
}
