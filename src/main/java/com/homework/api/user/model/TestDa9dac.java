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
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Builder
@Table(name = "TEST_da9dac", catalog = "test")
public class TestDa9dac {

	@Id
	@Column(name = "USER_ID")
	private String userId;

	@Column(name = "USER_NM", nullable = false)
	private String userNm;

	@Column(name = "PW", nullable = false)
	private String pw;

	@CreatedDate
	@Column(name = "REGI_DT", updatable = false)
	private LocalDateTime regiDt;

	@Column(name = "REGI_USER", nullable = false)
	private String regiUser;

	@LastModifiedDate
	@Column(name = "UPDA_DT")
	private LocalDateTime updaDt;

	@Column(name = "UPDA_USER")
	private String updaUser;

	@ColumnDefault("Y")
	@Column(name = "USE_YN", nullable = false)
	private String useYn;
}
