package com.ysh.test.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ysh.test.entity.Users2;
import com.ysh.test.repository.TestRepository;

@Service
public class TestService {

	private final TestRepository testRepository;

	@Autowired
	public TestService(TestRepository testRepository) {
		this.testRepository = testRepository;
	}

	@Transactional
	public void registerUser(String name, String email) {
		Users2 user = new Users2(name, email);
		testRepository.save(user);
	}

	public Optional<Users2> getUser(Long id) {
		return testRepository.findById(id);
	}

}
