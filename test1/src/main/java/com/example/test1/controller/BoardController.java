package com.example.test1.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.test1.dao.BoardService;
import com.google.gson.Gson;



@Controller
public class BoardController {
	@Autowired
	BoardService BoardService;
	
	//게시글 목록 페이지
	@RequestMapping("/board-list.do") 
	//이 주소로 들어오면 아래 코드를 실행하겠다.
    public String boardList(Model model) throws Exception{

        return "/board-list";
    }
	
	@RequestMapping("/board-insert.do") 
	//이 주소로 들어오면 아래 코드를 실행하겠다.
    public String boardInsert(Model model) throws Exception{

        return "/board-insert";
    }
	
	@RequestMapping(value = "/board-list.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String board_list(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap = BoardService.searchBoardList(map);
		
		return new Gson().toJson(resultMap); // json 형태로 바꿔주는 애
	}
	
	@RequestMapping(value = "/board-remove.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String board_remove(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap = BoardService.removeBoard(map);
		
		return new Gson().toJson(resultMap); // json 형태로 바꿔주는 애
	}
	
	@RequestMapping(value = "/board-add.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String board_add(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap = BoardService.addBoard(map);
		return new Gson().toJson(resultMap); // json 형태로 바꿔주는 애
	}
	
}
