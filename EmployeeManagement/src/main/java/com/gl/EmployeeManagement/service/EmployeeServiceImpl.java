package com.gl.EmployeeManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gl.EmployeeManagement.entity.Employee;
import com.gl.EmployeeManagement.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		List<Employee> employee = employeeRepository.findAll();
		return employee;
	}

	@Override
	public Employee findById(int id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	public void DeleteById(int id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> searchBy(String firstName) {
		List<Employee> employee = employeeRepository.findByFirstNameContainsIgnoreCase(firstName);
		return employee;
	}

	@Override
	public List<Employee> getEmployeesCustomSortedById(Direction direction) {
		return employeeRepository.findAll(Sort.by(direction, "id"));
	}

}
