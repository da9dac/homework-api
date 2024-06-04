package com.homework.api.user.controller.dto;

import java.util.ArrayList;

public class DeleteRequest {

	private ArrayList<String> userIds;
	private String updaUser;

	public DeleteRequest(ArrayList<String> userIds, String updaUser) {
		this.userIds = userIds;
		this.updaUser = updaUser;
	}

	public ArrayList<String> getUserIds() {
		return userIds;
	}

	public String getUpdaUser() {
		return updaUser;
	}
}
