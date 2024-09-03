package com.example.test1.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.test1.dao.AreaService;
import com.example.test1.dao.BoardService;
import com.google.gson.Gson;

@Controller
public class AreaController {

	@Autowired
	AreaService areaService;
	
	// 게시글 작성
	@RequestMapping("/area-list.do") 
    public String boardInsert(Model model) throws Exception{

        return "/area";
    }
	
	@RequestMapping(value = "/area-list.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String area_list(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap 
			= new HashMap<String, Object>();
		resultMap = areaService.searchAreaList(map);
		System.out.println("Controller =>" +map);
		
		return new Gson().toJson(resultMap);
	}
	
}
