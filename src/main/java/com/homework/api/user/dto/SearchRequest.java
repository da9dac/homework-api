package com.homework.api.user.dto;

public class SearchRequest {

	private String userNm;
	private String userId;
	private String regiUser;
	private String updaUser;
	private String regiDtFrom;
	private String regiDtTo;
	private String updaDtFrom;
	private String updaDtTo;

	public SearchRequest() {
	}

	public SearchRequest(String userNm, String userId, String regiUser, String updaUser, String regiDtFrom,
		String regiDtTo,
		String updaDtFrom, String updaDtTo) {
		this.userNm = userNm;
		this.userId = userId;
		this.regiUser = regiUser;
		this.updaUser = updaUser;
		this.regiDtFrom = regiDtFrom;
		this.regiDtTo = regiDtTo;
		this.updaDtFrom = updaDtFrom;
		this.updaDtTo = updaDtTo;
	}

	public String getUserNm() {
		return userNm;
	}

	public String getUserId() {
		return userId;
	}

	public String getRegiUser() {
		return regiUser;
	}

	public String getUpdaUser() {
		return updaUser;
	}

	public String getRegiDtFrom() {
		return regiDtFrom;
	}

	public String getRegiDtTo() {
		return regiDtTo;
	}

	public String getUpdaDtFrom() {
		return updaDtFrom;
	}

	public String getUpdaDtTo() {
		return updaDtTo;
	}
}
