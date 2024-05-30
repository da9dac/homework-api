package com.homework.api.user.controller.dto;

import java.time.LocalDateTime;

import com.homework.api.user.model.TestDa9dac;

public class UserRegiDTO {

	private String userId;
	private String userNm;
	private String pw;
	private String regiUser;
	private String useYn;

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

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public UserRegiDTO() {}

	protected UserRegiDTO(String userId, String userNm, String pw, String regiUser, String useYn) {
		this.userId = userId;
		this.userNm = userNm;
		this.pw = pw;
		this.regiUser = regiUser;
		this.useYn = useYn;
	}

	public TestDa9dac DTOToEntity() {
		return new TestDa9dac(userId, userNm, pw, regiUser, useYn);
	}
}

