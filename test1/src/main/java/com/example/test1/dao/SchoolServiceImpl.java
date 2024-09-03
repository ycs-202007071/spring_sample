package com.example.test1.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test1.mapper.SchoolMapper;
import com.example.test1.mapper.StudentMapper;
import com.example.test1.model.Board;
import com.example.test1.model.Emp;
import com.example.test1.model.School;
import com.example.test1.model.Student;

@Service
public class SchoolServiceImpl implements SchoolService{

	@Autowired
	SchoolMapper schoolMapper;
	

	@Override
	public HashMap<String, Object> searchSchoolList(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap 
		= new HashMap<String, Object>();
		try {
			int count = schoolMapper.selectSchoolCnt(map);
			List<School> list = schoolMapper.selectSchoolList(map);
			resultMap.put("list", list);
			resultMap.put("count", count);
			resultMap.put("result", "success");
		} catch (Exception e) {
			// TODO: handle exception
			resultMap.put("result", "fail");
		}
		return resultMap;
	}


	@Override
	public HashMap<String, Object> searchSchoolInfo(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
			HashMap<String, Object> resultMap =
					new HashMap<String, Object>();
			
			try {
				School school = schoolMapper.selectSchoolInfo(map);
				resultMap.put("info", school);
				resultMap.put("result", "success");
				resultMap.put("message", "검색되었습니다.");
				System.out.println("school");
			} catch (Exception e) {
				// TODO: handle exception
				resultMap.put("result", "fail");
				resultMap.put("message", "예기치 못한 문제가 발생했습니다. \n나중에 다시 시도해주세요.");
			}
			System.out.println("service" + resultMap);
			
		return resultMap;
	}


	@Override
	public HashMap<String, Object> removeSchool(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap =
				new HashMap<String, Object>();
		try {
			schoolMapper.deleteSchool(map);
			resultMap.put("message", "삭제되었습니다.");
		} catch (Exception e) {
			// TODO: handle exception
			resultMap.put("message", "예기치 못한 문제가 발생했습니다. \n나중에 다시 시도해주세요.");
		}
		
		return resultMap;
	}


	@Override
	public HashMap<String, Object> addSchool(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			System.out.println("되는게 없어");
			schoolMapper.insertSchool(map);
			resultMap.put("result", "success");
			resultMap.put("message", "등록되었습니다.");
		} catch (Exception e) {
			// TODO: handle exception
			resultMap.put("result", "fail");
			resultMap.put("message", "예기치 못한 문제가 발생했습니다. \n나중에 다시 시도해주세요.");
		}
		return resultMap;
	}

	
}
