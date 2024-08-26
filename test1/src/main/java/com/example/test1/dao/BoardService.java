package com.example.test1.dao;

import java.util.HashMap;

import com.example.test1.model.Board;

public interface BoardService {
	//게시글 목록
	HashMap<String, Object> searchBoardList(HashMap<String, Object> map);
	//게시글 삭제
	HashMap<String, Object> removeBoard(HashMap<String, Object> map);
	//게시글 추가
	HashMap<String, Object> addBoard(HashMap<String, Object> map);
	
}
