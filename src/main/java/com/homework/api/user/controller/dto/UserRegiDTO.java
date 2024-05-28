package com.homework.api.user.controller.dto;

import java.time.LocalDateTime;

import com.homework.api.user.model.TestDa9dac;

public class UserRegiDTO {

	private String userId;
	private String userNm;
	private String pw;
	private String regiUser;
	private String useYn;

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setRegiUser(String regiUser) {
		this.regiUser = regiUser;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public TestDa9dac DTOToEntity() {
		return new TestDa9dac(userId, userNm, pw, regiUser, useYn);
	}
}
