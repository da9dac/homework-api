package com.homework.api.user.controller.dto;

public class DeleteRequest {

	private String userId;
	private String updaUser;

	public DeleteRequest(String userId, String updaUser) {
		this.userId = userId;
		this.updaUser = updaUser;
	}

	public String getUserId() {
		return userId;
	}

	public String getUpdaUser() {
		return updaUser;
	}
}
