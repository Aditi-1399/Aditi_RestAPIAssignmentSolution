package com.gl.EmployeeManagement;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gl.EmployeeManagement.entity.Role;
import com.gl.EmployeeManagement.entity.User;
import com.gl.EmployeeManagement.repository.RoleRepository;
import com.gl.EmployeeManagement.repository.UserRepository;

@SpringBootApplication
public class EmployeeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Bean
	public void initialise() {

		Role role1 = new Role();
		role1.setName("ROLE_ADMIN");
		roleRepository.save(role1);

		Role role2 = new Role();
		role2.setName("ROLE_USER");
		roleRepository.save(role2);

		User user1 = new User();
		user1.setUsername("abc");
		user1.setPassword(encoder().encode("abc"));
		user1.setRoles(Arrays.asList(role1, role2));

		userRepository.save(user1);

		User user2 = new User();
		user2.setUsername("xyz");
		user2.setPassword(encoder().encode("xyz"));
		user2.setRoles(Arrays.asList(role2));
		userRepository.save(user2);

	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}
