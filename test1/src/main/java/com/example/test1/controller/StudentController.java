package com.example.test1.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.test1.dao.StudentService;
import com.example.test1.model.Emp;
import com.example.test1.model.Student;
import com.google.gson.Gson;

@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/student.do") 
	//이 주소로 들어오면 아래 코드를 실행하겠다.
    public String main(Model model) throws Exception{

        return "/student-list";
    }
	
	@RequestMapping("/test.do") 
    public String test(Model model) throws Exception{

        return "/test";
    }
	
	@RequestMapping("/emp.do") 
    public String emp(Model model) throws Exception{

        return "/emp-list";
    }
	
	
	@RequestMapping(value = "/list.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String searchBbsList(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		List<Student> list = studentService.searchStudentList(map);
		resultMap.put("list", list);
		resultMap.put("result", "success");
		return new Gson().toJson(resultMap);
	}
	
	@RequestMapping(value = "/ok.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String qwer(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		Student stu = studentService.searchQwer();
		
		resultMap.put("stu", stu);
		resultMap.put("result", "success");
		
		return new Gson().toJson(resultMap); // json 형태로 바꿔주는 애
	}
	
	@RequestMapping(value = "/search.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String serch(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap= studentService.searchStu(map);
		return new Gson().toJson(resultMap); // json 형태로 바꿔주는 애
	}
	
	@RequestMapping(value = "/empList.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String emp(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		List<Emp> emp = studentService.searchEmp();
		
		resultMap.put("emp", emp);
		resultMap.put("result", "success");
		
		return new Gson().toJson(resultMap); // json 형태로 바꿔주는 애
	}


}


