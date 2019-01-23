package com.tvoseguridadelectronica.oss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tvoseguridadelectronica.oss.domain.Employee;
import com.tvoseguridadelectronica.oss.jparepository.EmployeeJpaRepository;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service(value = "userService")
public class EmployeeServiceImpl implements UserDetailsService, EmployeeService {

	@Autowired
	private EmployeeJpaRepository employeeJpaRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee employee = employeeJpaRepository.findByUsername(username);
		
		return new org.springframework.security.core.userdetails.User(employee.getUsername(), employee.getPassword(),
				getAuthority(employee));
		
	}

	private List<SimpleGrantedAuthority> getAuthority(Employee employee ) {
				
		return Arrays.asList(new SimpleGrantedAuthority(employee.getRole().getName()));
	}	

	public List<Employee> findAll() {
		List<Employee> list = new ArrayList<>();
		employeeJpaRepository.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(String id) {
		employeeJpaRepository.deleteById(id);
	}

	@Override
	public Employee findOne(String loginEmployee) {
		return employeeJpaRepository.findByUsername(loginEmployee);
	}

	@Override
	public Employee findById(String id) {
		return employeeJpaRepository.findById(id).get();
	}
	
}
