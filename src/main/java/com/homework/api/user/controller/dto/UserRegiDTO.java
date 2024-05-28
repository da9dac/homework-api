package com.homework.api.user.controller.dto;

import java.time.LocalDateTime;

import com.homework.api.user.model.TestDa9dac;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class UserRegiDTO {

	private String userId;
	private String userNm;
	private String pw;
	private String regiUser;
	private String useYn;

	public TestDa9dac DTOToEntity() {
		return TestDa9dac.builder()
			.userId(userId)
			.userNm(userNm)
			.pw(pw)
			.regiUser(regiUser)
			.useYn(useYn)
			.build();
	}
}

