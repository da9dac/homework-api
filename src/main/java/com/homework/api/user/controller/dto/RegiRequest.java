package com.homework.api.user.controller.dto;

import com.homework.api.user.model.TestDa9dac;

public class RegiRequest {

	private String userId;
	private String userNm;
	private String pw;
	private String regiUser;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getRegiUser() {
		return regiUser;
	}

	public void setRegiUser(String regiUser) {
		this.regiUser = regiUser;
	}

	public RegiRequest() {}

	protected RegiRequest(String userId, String userNm, String pw, String regiUser) {
		this.userId = userId;
		this.userNm = userNm;
		this.pw = pw;
		this.regiUser = regiUser;
	}

	public TestDa9dac DTOToEntity() {
		return new TestDa9dac(userId, userNm, pw, regiUser);
	}
}

