package com.example.test1.model;

import lombok.Data;

@Data
public class Board {
	private int boardNo;
	private String title;
	private String contents;
	private String userId;
	private int hit;
	private String category;
	private String ravorite;
	private String tag1;
	private String tag2;
	private String noticeYn;
	private String cdateTime;
	private String udateTime;
	
}
