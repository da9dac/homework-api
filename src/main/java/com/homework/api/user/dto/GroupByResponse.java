package com.homework.api.user.dto;

public class GroupByResponse {

	private String regiDt;
	private Long userCount;

	public GroupByResponse() {
	}

	public GroupByResponse(String regiDt, Long userCount) {
		this.regiDt = regiDt;
		this.userCount = userCount;
	}

	public String getRegiDt() {
		return regiDt;
	}

	public void setRegiDt(String regiDt) {
		this.regiDt = regiDt;
	}

	public Long getUserCount() {
		return userCount;
	}

	public void setUserCount(Long userCount) {
		this.userCount = userCount;
	}
}
