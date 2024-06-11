package com.homework.api.user.service;

import static com.homework.api.user.model.QTestDa9dac.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.homework.api.user.dto.DeleteRequest;
import com.homework.api.user.dto.GroupByResponse;
import com.homework.api.user.dto.SearchRequest;
import com.homework.api.user.dto.SearchResult;
import com.homework.api.user.dto.UpdateRequest;
import com.homework.api.user.model.TestDa9dac;
import com.homework.api.user.repository.TestDa9dacRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringTemplate;
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
		user.setUpdaDt(LocalDateTime.now());

		testDa9dacRepository.save(user);
	}

	@Transactional
	public void deleteUser(DeleteRequest request) {
		testDa9dacRepository.updateUseYnAndUpdaUserByUserIdIn(request.getUserIds(), request.getUpdaUser());
	}

	public SearchResult getUsers(SearchRequest request) {
		SearchResult result = new SearchResult(search(request), groupBy(request));
		return result;
	}

	private List<TestDa9dac> search(SearchRequest params) {
		JPAQueryFactory jq = new JPAQueryFactory(em);

		return jq
			.selectFrom(testDa9dac)
			.where(
				userNmLike(params.getUserNm()),
				userIdLike(params.getUserId()),
				regiUserLike(params.getRegiUser()),
				updaUserLike(params.getUpdaUser()),
				regiDtBetween(params.getRegiDtFrom(), params.getRegiDtTo()),
				updaDtBetween(params.getUpdaDtFrom(), params.getUpdaDtTo()),
				useYnEqToY("")
			)
			.fetch();
	}

	private List<GroupByResponse> groupBy(SearchRequest params) {
		JPAQueryFactory jq = new JPAQueryFactory(em);

		return jq
			.select(Projections.constructor(GroupByResponse.class,
				convertRegiDt(),
				testDa9dac.count().as("userCount")))
			.from(testDa9dac)
			.where(
				userNmLike(params.getUserNm()),
				userIdLike(params.getUserId()),
				regiUserLike(params.getRegiUser()),
				updaUserLike(params.getUpdaUser()),
				regiDtBetween(params.getRegiDtFrom(), params.getRegiDtTo()),
				updaDtBetween(params.getUpdaDtFrom(), params.getUpdaDtTo()),
				useYnEqToY("Y")
			)
			.groupBy(convertRegiDt())
			.fetch();
	}

	private BooleanExpression userNmLike(String condition) {
		if (!condition.isEmpty()) {
			return testDa9dac.userNm.like("%" + condition + "%");
		}
		return null;
	}

	private BooleanExpression userIdLike(String condition) {
		if (!condition.isEmpty()) {
			return testDa9dac.userId.like("%" + condition + "%");
		}
		return null;
	}

	private BooleanExpression regiUserLike(String condition) {
		if (!condition.isEmpty()) {
			return testDa9dac.regiUser.like("%" + condition + "%");
		}

		return null;
	}

	private BooleanExpression updaUserLike(String condition) {
		if (!condition.isEmpty()) {
			return testDa9dac.updaUser.like("%" + condition + "%");
		}
		return null;
	}

	private BooleanExpression regiDtBetween(String regiFrom, String regiTo) {
		if (!regiFrom.isEmpty() && !regiTo.isEmpty()) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDateTime from = LocalDate.parse(regiFrom, formatter).atStartOfDay();
			LocalDateTime to = LocalDate.parse(regiTo, formatter).atTime(LocalTime.MAX);

			return testDa9dac.regiDt.between(from, to);
		}
		return null;
	}

	private BooleanExpression updaDtBetween(String updaFrom, String updaTo) {
		if (!updaFrom.isEmpty() && !updaTo.isEmpty()) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDateTime from = LocalDate.parse(updaFrom, formatter).atStartOfDay();
			LocalDateTime to = LocalDate.parse(updaTo, formatter).atTime(LocalTime.MAX);

			return testDa9dac.updaDt.between(from, to);
		}
		return null;
	}

	private BooleanExpression useYnEqToY(String condition) {
		if (!condition.isEmpty()) return testDa9dac.useYn.eq(condition);
		return null;
	}

	private StringTemplate convertRegiDt() {
		return Expressions.stringTemplate("CONVERT(char(10), {0}, 23)", testDa9dac.regiDt);
	}
}
