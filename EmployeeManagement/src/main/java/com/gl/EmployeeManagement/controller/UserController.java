package com.gl.EmployeeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.EmployeeManagement.entity.User;
import com.gl.EmployeeManagement.service.UserService;

@RestController
@RequestMapping("/api/employees")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/addUser")
	public User addUser(User user) {
		userService.save(user);
		return user;
	}

}
