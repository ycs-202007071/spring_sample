package com.example.test1.dao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test1.mapper.AreaMapper;
import com.example.test1.mapper.BoardMapper;
import com.example.test1.model.Area;
import com.example.test1.model.Board;

@Service
public class AreaServiceImpl implements AreaService{

	@Autowired
	AreaMapper areaMapper;

	@Override
	public HashMap<String, Object> searchAreaList(HashMap<String, Object> map) {
		HashMap<String, Object> resultMap = new HashMap<>();
		List<Area> list = null;
		if(!map.get("gu").equals("")) {
			System.out.println("dong =>" + map.get("dong"));
			list = areaMapper.selectDongList(map);
			System.out.println(list);
		} else if (!map.get("si").equals("")) {
			list = areaMapper.selectGuList(map);
		} else {
			list = areaMapper.selectAreaList(map);
		}
//		for(Area area : list) {
//			System.out.println(area.dong);
//		}
		resultMap.put("list", list);
		System.out.println("service =>" +resultMap);
		return resultMap;
	}

	
	
}
