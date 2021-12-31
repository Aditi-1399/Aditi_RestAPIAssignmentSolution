package com.gl.EmployeeManagement.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.gl.EmployeeManagement.service.MyUserDetailsService;

@EnableWebSecurity

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	MyUserDetailsService service;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service);

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console", "/h2-console/**");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/api/employees/addEmployee").hasRole("ADMIN")
				.antMatchers("/api/employees/getAllEmployees", "/api/employees/deleteEmployee",
						"/api/employees/findEmployeeById", "/api/employees/searchEmployeesByName",
						"/api/employees/sortById")
				.hasAnyRole("ADMIN", "USER").antMatchers("/api/employees/addUser", "/api/employees/addRole").permitAll()
				.anyRequest().authenticated().and().formLogin().and().logout().and().cors().and().csrf().disable();
	}

}
