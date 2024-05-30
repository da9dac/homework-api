package com.homework.api.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public void updateUser() {

	}

	@Transactional
	public void deleteUser() {

	}
}
