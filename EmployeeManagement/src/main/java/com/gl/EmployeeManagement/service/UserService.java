package com.gl.EmployeeManagement.service;

import org.springframework.web.bind.annotation.ResponseBody;

import com.gl.EmployeeManagement.entity.User;

public interface UserService {

	void save(User theUser);

}
