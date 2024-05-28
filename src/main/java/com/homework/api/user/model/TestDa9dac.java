package com.homework.api.user.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TEST_da9dac", catalog = "test")
public class TestDa9dac {

	@Id
	@Column(name = "USER_ID")
	private String userId;

	@Column(name = "USER_NM", nullable = false)
	private String userNm;

	@Column(name = "PW", nullable = false)
	private String pw;

	@Column(name = "REGI_DT")
	private LocalDateTime regiDt;

	@Column(name = "REGI_USER", nullable = false)
	private String regiUser;

	@Column(name = "UPDA_DT")
	private LocalDateTime updaDt;

	@Column(name = "UPDA_USER")
	private String updaUser;

	@Column(name = "USE_YN", nullable = false)
	private String useYn;

	public String getUserId() {
		return userId;
	}

	public String getUserNm() {
		return userNm;
	}

	public String getPw() {
		return pw;
	}

	public LocalDateTime getRegiDt() {
		return regiDt;
	}

	public String getRegiUser() {
		return regiUser;
	}

	public LocalDateTime getUpdaDt() {
		return updaDt;
	}

	public String getUpdaUser() {
		return updaUser;
	}

	public String getUseYn() {
		return useYn;
	}
}
