package com.homework.api.user.controller.dto;

public class UpdateRequest {

	private String userId;
	private String userNm;
	private String pw;
	private String updaUser;

	public UpdateRequest(String userId, String userNm, String pw, String updaUser) {
		this.userId = userId;
		this.userNm = userNm;
		this.pw = pw;
		this.updaUser = updaUser;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserNm() {
		return userNm;
	}

	public String getPw() {
		return pw;
	}

	public String getUpdaUser() {
		return updaUser;
	}
}