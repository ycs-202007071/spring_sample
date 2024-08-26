package com.example.test1.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test1.mapper.BoardMapper;
import com.example.test1.model.Board;
import com.example.test1.model.Student;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired // 사용하지 않을 경우 알아서 소멸해주고 데이터가 많더라도 알아서 처리해주는 애
	BoardMapper boardMapper;

	@Override
	public HashMap<String, Object> searchBoardList(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap<>();
		List<Board> list = boardMapper.selectBoardList(map);
		resultMap.put("list", list);
		
		return resultMap;
	
	}

	@Override
	public HashMap<String, Object> removeBoard(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		try {
			boardMapper.deleteBoard(map);
			resultMap.put("message", "삭제되었습니다.");
		} catch (Exception e) {
			// TODO: handle exception
			resultMap.put("message", "오류");
		}
		return resultMap;
	}

	@Override
	public HashMap<String, Object> addBoard(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap<>();
		try {
			boardMapper.insertBoard(map);
			resultMap.put("result", "success");
			resultMap.put("message", "입력되었습니다.");
		} catch (Exception e) {
			// TODO: handle exception
			resultMap.put("result", "fail");
			resultMap.put("message", "오류");
		}
		return resultMap;
	}
}
