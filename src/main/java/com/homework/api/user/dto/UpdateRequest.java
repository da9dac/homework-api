package com.homework.api.user.dto;

public class UpdateRequest {

	private String userId;
	private String userNm;
	private String pw;
	private String updaUser;
	private String useYn;

	public UpdateRequest(String userId, String userNm, String pw, String updaUser, String useYn) {
		this.userId = userId;
		this.userNm = userNm;
		this.pw = pw;
		this.updaUser = updaUser;
		this.useYn = useYn;
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

	public String getUseYn() {
		return useYn;
	}
}
