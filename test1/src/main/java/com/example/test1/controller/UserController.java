package com.example.test1.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.test1.dao.UserService;
import com.google.gson.Gson;

@Controller
public class UserController {
	@Autowired
	UserService userSevice;
	
	@RequestMapping("/login.do") 
    public String login(Model model) throws Exception{

        return "/login";
    }
	
	@RequestMapping("/join.do") 
    public String join(Model model) throws Exception{

        return "/join";
    }
	
	@RequestMapping("/user-list.do") 
    public String userList(Model model) throws Exception{

        return "/user-list";
    }
	
	
	
	
	@RequestMapping(value = "/idCheck.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String idCheck(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap 
			= new HashMap<String, Object>();
		resultMap = userSevice.selectUserInfo(map);
		
		return new Gson().toJson(resultMap);
	}
	
	@RequestMapping(value = "/user-list.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String userList(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap 
			= new HashMap<String, Object>();
		resultMap = userSevice.searchUserList(map);
		
		return new Gson().toJson(resultMap);
	}
	
	@RequestMapping(value = "/board-list-user.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String boardListUser(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap 
			= new HashMap<String, Object>();
		resultMap = userSevice.searchBoardListUser(map);
		
		return new Gson().toJson(resultMap);
	}
	
	@RequestMapping(value = "/user-delete.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String deleteUser(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap 
			= new HashMap<String, Object>();
		resultMap = userSevice.removeUser(map);
		
		return new Gson().toJson(resultMap);
	}
	
}
