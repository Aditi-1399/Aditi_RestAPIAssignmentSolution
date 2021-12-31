package com.gl.EmployeeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.EmployeeManagement.entity.Role;
import com.gl.EmployeeManagement.service.RoleService;

@RestController
@RequestMapping("/api/employees")
public class RoleController {

	@Autowired
	RoleService roleService;

	@PostMapping("/addRole")
	public Role addRole(Role role) {
		roleService.save(role);
		return role;
	}

}
