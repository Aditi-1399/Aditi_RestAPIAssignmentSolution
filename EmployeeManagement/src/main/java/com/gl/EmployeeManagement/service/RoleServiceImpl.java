package com.gl.EmployeeManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.EmployeeManagement.entity.Role;
import com.gl.EmployeeManagement.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Override
	public void save(Role theRole) {
		roleRepository.save(theRole);

	}

}
