package com.gl.EmployeeManagement.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import com.gl.EmployeeManagement.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();

	Employee findById(int id);

	void save(Employee theEmployee);

	void DeleteById(int id);

	List<Employee> searchBy(String firstName);

	List<Employee> getEmployeesCustomSortedById(Direction direction);

}
