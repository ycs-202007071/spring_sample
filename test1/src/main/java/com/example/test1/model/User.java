package com.example.test1.model;

import lombok.Data;

@Data
public class User {
	private String userId;
	private String pwd;
	private String userName;
	private String email;
	private String phone;
	private String gender;
	
	public String getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	
}
