package com.homework.api.user.service;

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

		QTestDa9dac testDa9dac = new QTestDa9dac("testDa9dac");
		List<TestDa9dac> list = jq.selectFrom(testDa9dac)
			.where(testDa9dac.userNm.like())
			.fetch();

		return list;
	}
}
