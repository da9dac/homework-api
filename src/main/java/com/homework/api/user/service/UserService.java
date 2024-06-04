package com.homework.api.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.homework.api.user.controller.dto.DeleteRequest;
import com.homework.api.user.controller.dto.UpdateRequest;
import com.homework.api.user.model.TestDa9dac;
import com.homework.api.user.repository.TestDa9dacRepository;

@Transactional(readOnly = true)
@Service
public class UserService {

	private TestDa9dacRepository testDa9dacRepository;

	public UserService(TestDa9dacRepository testDa9dacRepository) {
		this.testDa9dacRepository = testDa9dacRepository;
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
}
