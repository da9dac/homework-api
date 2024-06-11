package com.homework.api.user.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "TEST_da9dac")
public class TestDa9dac {

	@Id
	@Column(name = "USER_ID")
	private String userId;

	@Column(name = "USER_NM")
	private String userNm;

	@Column(name = "PW")
	private String pw;

	@CreatedDate
	@Column(name = "REGI_DT", updatable = false)
	private LocalDateTime regiDt;

	@Column(name = "REGI_USER")
	private String regiUser;

	@LastModifiedDate
	@Column(name = "UPDA_DT", insertable = false)
	private LocalDateTime updaDt;

	@Column(name = "UPDA_USER")
	private String updaUser;

	@ColumnDefault("Y")
	@Column(name = "USE_YN")
	private String useYn = "Y";

	public TestDa9dac() {}

	protected TestDa9dac(String userId, String userNm, String pw, LocalDateTime regiDt, String regiUser,
		LocalDateTime updaDt,
		String updaUser, String useYn) {
		this.userId = userId;
		this.userNm = userNm;
		this.pw = pw;
		this.regiDt = regiDt;
		this.regiUser = regiUser;
		this.updaDt = updaDt;
		this.updaUser = updaUser;
		this.useYn = useYn;
	}

	public TestDa9dac(String userNm, String userId, String pw, String regiUser) {
		this.userNm = userNm;
		this.userId = userId;
		this.pw = pw;
		this.regiUser = regiUser;
	}

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

	public LocalDateTime getRegiDt() {
		return regiDt;
	}

	public void setRegiDt(LocalDateTime regiDt) {
		this.regiDt = regiDt;
	}

	public String getRegiUser() {
		return regiUser;
	}

	public void setRegiUser(String regiUser) {
		this.regiUser = regiUser;
	}

	public LocalDateTime getUpdaDt() {
		return updaDt;
	}

	public void setUpdaDt(LocalDateTime updaDt) {
		this.updaDt = updaDt;
	}

	public String getUpdaUser() {
		return updaUser;
	}

	public void setUpdaUser(String updaUser) {
		this.updaUser = updaUser;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
}
