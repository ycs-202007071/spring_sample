package com.example.test1.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.test1.dao.SchoolService;
import com.google.gson.Gson;

@Controller
public class SchoolController {

	@Autowired
	SchoolService schoolService;
	
	@RequestMapping("/school-stu.do") 
    public String schooStu(Model model) throws Exception{

        return "/school-stu";
    }
	
	//작성
	@RequestMapping("/school-insert.do") 
    public String boardInsert(Model model) throws Exception{

        return "/school-insert";
    }
	// 게시글 상세보기
	@RequestMapping("/school-view.do") 
    public String boardView(HttpServletRequest request, Model model, @RequestParam HashMap<String, Object> map) throws Exception{
		model.addAttribute("stuNo", map.get("stuNo"));
        return "/school-view";
    }

	
	@RequestMapping(value = "/school-stu.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String searchSchoolList(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> list = schoolService.searchSchoolList(map);
		return new Gson().toJson(list);
	}
	
	@RequestMapping(value = "/school-view.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String school_view(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = schoolService.searchSchoolInfo(map);
		System.out.println("controller" + resultMap);
		return new Gson().toJson(resultMap);
	}
	
	@RequestMapping(value = "/school-remove.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String board_remove(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap 
			= new HashMap<String, Object>();
		resultMap = schoolService.removeSchool(map);
		
		return new Gson().toJson(resultMap);
	}
	
	@RequestMapping(value = "/school-add.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String school_add(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap 
			= new HashMap<String, Object>();
		resultMap = schoolService.addSchool(map);
		
		return new Gson().toJson(resultMap);
	}
	
}
