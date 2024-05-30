package com.homework.api.user.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homework.api.user.controller.dto.UserRegiDTO;
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
		return ResponseEntity.ok(userService.getUsers());
	}

	@PostMapping("/regiUser")
	public void regiUser(@RequestBody UserRegiDTO request) {
		userService.addUser(request.DTOToEntity());
	}

	@PostMapping("update")
	public void updateUser(@RequestBody UserRegiDTO request) {
		userService.updateUser();
	}

	@PostMapping("delete")
	public void deleteUser(@RequestBody UserRegiDTO request) {
		userService.deleteUser();
	}
}
