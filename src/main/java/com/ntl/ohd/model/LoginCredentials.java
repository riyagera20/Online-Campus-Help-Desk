package com.ntl.ohd.model;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginCredentials {
	
	private int userId;
	
	@NotEmpty
	private String password;

	public int getUserId() {
		
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
