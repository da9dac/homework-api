package com.homework.api.user.controller;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homework.api.user.dto.DeleteRequest;
import com.homework.api.user.dto.RegiRequest;
import com.homework.api.user.dto.UpdateRequest;
import com.homework.api.user.model.TestDa9dac;
import com.homework.api.user.service.UserService;

@RequestMapping("/bi/user")
@RestController
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/table")
	public ResponseEntity<List<TestDa9dac>> table() {
		return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
	}

	@PostMapping("/regiUser")
	public void regiUser(@RequestBody RegiRequest request) {
		userService.addUser(request.DTOToEntity());
	}

	@PostMapping("/update")
	public void updateUser(@RequestBody UpdateRequest request) {
		userService.updateUser(request);
	}

	@PostMapping("/delete")
	public void deleteUser(@RequestBody DeleteRequest request) {
		userService.deleteUser(request);
	}

	@PostMapping("/search")
	public ResponseEntity<List<TestDa9dac>> search(@RequestBody Map<String, String> params) {
		ResponseEntity<List<TestDa9dac>> response =
			new ResponseEntity<>(userService.search(params), HttpStatus.OK);
		return response;
	}
}
