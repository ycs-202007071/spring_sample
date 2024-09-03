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

import com.example.test1.dao.TestService;
import com.example.test1.model.Board;
import com.example.test1.model.Student;
import com.google.gson.Gson;

@Controller
public class TestController {
	@Autowired
	TestService testService;
	
	@RequestMapping("/test1.do") 
    public String test(Model model) throws Exception{

        return "/test1";
    }
	
	@RequestMapping(value = "/test1.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String searchBbsList(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		List<Board> test = testService.getTest(map);
		return new Gson().toJson(test);
	}
}
