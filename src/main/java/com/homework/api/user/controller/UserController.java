package com.homework.api.user.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homework.api.user.dto.DeleteRequest;
import com.homework.api.user.dto.RegiRequest;
import com.homework.api.user.dto.GroupByResponse;
import com.homework.api.user.dto.SearchRequest;
import com.homework.api.user.dto.SearchResult;
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

	@PostMapping("/table")
	public ResponseEntity<SearchResult> table(@RequestBody SearchRequest request) {
		ResponseEntity<SearchResult> response =
			new ResponseEntity<>(userService.getUsers(request), HttpStatus.OK);

		return response;
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
}
