package com.example.test1.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test1.mapper.UserMapper;
import com.example.test1.model.Board;
import com.example.test1.model.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserMapper userMapper;
	
	public HashMap<String, Object> selectUserInfo(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap<>();
		
		try {
			User user = userMapper.selectUserInfo(map);
			resultMap.put("info", user);
			resultMap.put("result", "success");
			resultMap.put("message", "조회완료");
			
		} catch (Exception e) {
			// TODO: handle exception
			resultMap.put("result", "fail");
			resultMap.put("message", "오류");
		}
		
		return resultMap;
	}
	
	@Override
	public HashMap<String, Object> addUser(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap =
				new HashMap<String, Object>();
		try {
			userMapper.insertUser(map);
			resultMap.put("result", "success");
			resultMap.put("message", "등록되었습니다.");
		} catch (Exception e) {
			// TODO: handle exception
			resultMap.put("result", "fail");
			resultMap.put("message", "예기치 못한 문제가 발생했습니다. \n나중에 다시 시도해주세요.");
		}
		return resultMap;
	}

	@Override
	public HashMap<String, Object> searchUserList(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap =	new HashMap<String, Object>();
		try {
			System.out.println(map);
			List<User> list = userMapper.selectUserList(map);
			resultMap.put("list", list);
			resultMap.put("result", "seccess");
		} catch (Exception e) {
			resultMap.put("result", "fail");
			// TODO: handle exception
		}
		return resultMap;
	}

	@Override
	public HashMap<String, Object> searchBoardListUser(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap<>();
		try {
			List<Board> list = userMapper.selectBoardListUser(map);
			resultMap.put("list", list);
			resultMap.put("result", "seccess");
		} catch (Exception e) {
			resultMap.put("result", "fail");
		}
		return resultMap;
	}

	@Override
	public HashMap<String, Object> removeUser(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap<>();
		System.out.println(map);
		try {
			userMapper.deleteUserId(map);
			resultMap.put("result", "seccess");
		} catch (Exception e) {
			resultMap.put("result", "fail");
		}
		return resultMap;
	}

	@Override
	public HashMap<String, Object> searchUser(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
				HashMap<String, Object> resultMap =
						new HashMap<String, Object>();
				try {
					User user = userMapper.selectUser(map);
					resultMap.put("info", user);
					resultMap.put("result", "success");
					resultMap.put("message", "검색되었습니다.");
				} catch (Exception e) {
					// TODO: handle exception
					resultMap.put("result", "fail");
					resultMap.put("message", "예기치 못한 문제가 발생했습니다. \n나중에 다시 시도해주세요.");
				}
				return resultMap;
				
			}
	}
