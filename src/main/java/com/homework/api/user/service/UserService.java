package com.homework.api.user.service;

import static com.homework.api.user.model.QTestDa9dac.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.homework.api.user.dto.DeleteRequest;
import com.homework.api.user.dto.UpdateRequest;
import com.homework.api.user.model.QTestDa9dac;
import com.homework.api.user.model.TestDa9dac;
import com.homework.api.user.repository.TestDa9dacRepository;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;

@Transactional(readOnly = true)
@Service
public class UserService {

	private TestDa9dacRepository testDa9dacRepository;
	@Autowired
	private EntityManager em;

	public UserService(TestDa9dacRepository testDa9dacRepository, EntityManager em) {
		this.testDa9dacRepository = testDa9dacRepository;
		this.em = em;
	}

	public List<TestDa9dac> getUsers() {
		return testDa9dacRepository.findAll();
	}

	@Transactional
	public void addUser(TestDa9dac testDa9dac) {
		testDa9dacRepository.save(testDa9dac);
	}

	@Transactional
	public void updateUser(UpdateRequest request) {
		TestDa9dac user = testDa9dacRepository.findById(request.getUserId()).orElseThrow(RuntimeException::new);

		if (!request.getUserNm().isEmpty()) user.setUserNm(request.getUserNm());
		if (!request.getPw().isEmpty()) user.setPw(request.getPw());
		if (!request.getUpdaUser().isEmpty()) user.setUpdaUser(request.getUpdaUser());
		if (!request.getUseYn().isEmpty()) user.setUseYn(request.getUseYn());

		testDa9dacRepository.save(user);
	}

	@Transactional
	public void deleteUser(DeleteRequest request) {
		testDa9dacRepository.updateUseYnAndUpdaUserByUserIdIn(request.getUserIds(), request.getUpdaUser());
	}

	public List<TestDa9dac> search(Map<String, String> params) {
		JPAQueryFactory jq = new JPAQueryFactory(em);

		return jq.selectFrom(testDa9dac)
			.where(
				userNmLike(params),
				userIdLike(params),
				regiUserLike(params),
				updaUserLike(params),
				regiDtBetween(params),
				updaDtBetween(params)
			)
			.fetch();
	}

	private BooleanExpression userNmLike(Map<String, String> params) {
		if (!params.get("userNm").isEmpty()) {
			return testDa9dac.userNm.like("%" + params.get("userNm") + "%");
		}
		return null;
	}

	private BooleanExpression userIdLike(Map<String, String> params) {
		if (!params.get("userId").isEmpty()) {
			return testDa9dac.userId.like("%" + params.get("userId") + "%");
		}
		return null;
	}

	private BooleanExpression regiUserLike(Map<String, String> params) {
		if (!params.get("regiUser").isEmpty()) {
			return testDa9dac.regiUser.like("%" + params.get("regiUser") + "%");
		}

		return null;
	}

	private BooleanExpression updaUserLike(Map<String, String> params) {
		if (!params.get("updaUser").isEmpty()) {
			return testDa9dac.updaUser.like("%" + params.get("updaUser") + "%");
		}
		return null;
	}

	private BooleanExpression regiDtBetween(Map<String, String> params) {
		if (!params.get("regiDtFrom").isEmpty() && !params.get("regiDtTo").isEmpty()) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDateTime from = LocalDateTime.parse(params.get("regiDtFrom"), formatter);
			LocalDateTime to = LocalDateTime.parse(params.get("regiDtTo"), formatter);

			return testDa9dac.regiDt.between(from, to);
		}
		return null;
	}

	private BooleanExpression updaDtBetween(Map<String, String> params) {
		if (!params.get("updaDtFrom").isEmpty() && !params.get("updaDtTo").isEmpty()) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDateTime from = LocalDateTime.parse(params.get("updaDtFrom"), formatter);
			LocalDateTime to = LocalDateTime.parse(params.get("updaDtTo"), formatter);

			return testDa9dac.updaDt.between(from, to);
		}
		return null;
	}
}
