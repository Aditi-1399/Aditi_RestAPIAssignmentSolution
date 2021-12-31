package com.gl.EmployeeManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.EmployeeManagement.entity.Employee;
import com.gl.EmployeeManagement.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		return employeeService.findAll();
	}

	@PostMapping("/addEmployee")
	public Employee addEmployee(Employee employee) {
		employeeService.save(employee);
		return employee;
	}

	@DeleteMapping("/deleteEmployee")
	public String deleteEmployee(int id) {
		employeeService.DeleteById(id);
		return "Deleted employee with id " + id;
	}

	@GetMapping("/findEmployeeById")
	public Employee findEmployeeById(int id) {
		return employeeService.findById(id);
	}

	@GetMapping("/searchEmployeesByName")
	public List<Employee> searchEmployeesByName(String firstName) {
		return employeeService.searchBy(firstName);
	}

	@GetMapping("/sortById")
	public List<Employee> ascendingOrder(Direction direction) {
		return employeeService.getEmployeesCustomSortedById(direction);
	}

	@RequestMapping("/updateEmployee")
	public Employee updateEmployee(int id, String firstName, String lastName, String email) {
		Employee employee = employeeService.findById(id);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setEmail(email);
		employeeService.save(employee);
		return employee;
	}

}
