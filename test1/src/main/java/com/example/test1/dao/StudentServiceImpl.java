package com.example.test1.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test1.mapper.StudentMapper;
import com.example.test1.model.Emp;
import com.example.test1.model.Student;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired // 사용하지 않을 경우 알아서 소멸해주고 데이터가 많더라도 알아서 처리해주는 애
	StudentMapper studentMapper;

	@Autowired // 사용하지 않을 경우 알아서 소멸해주고 데이터가 많더라도 알아서 처리해주는 애
	StudentMapper empMapper;
	
	@Override
	public List<Student> searchStudentList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return studentMapper.selectStudentList(map);
	}

	@Override
	public Student searchQwer() {
		// TODO Auto-generated method stub
		Student s = studentMapper.qwer();
		return s;
	}

	@Override
	public HashMap<String, Object> searchStu(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			Student s = studentMapper.selectStu(map);
			resultMap.put("stu", s);
			resultMap.put("result", "success");
			String msg = s !=null ? "조회했습니다." : "학번을 확인해주세요.";
			resultMap.put("message", msg);
		} catch (Exception e) {
			resultMap.put("result", "fail");
			resultMap.put("message", "db조회 오류");
			
		}
		
		return resultMap;
		
		
	}
	

	@Override
	public List<Emp> searchEmp() {
		List<Emp> m = empMapper.selectEmp();
		return m;
	}

	
	

}
