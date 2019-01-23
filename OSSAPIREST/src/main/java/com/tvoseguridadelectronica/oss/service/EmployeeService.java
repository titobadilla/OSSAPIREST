package com.tvoseguridadelectronica.oss.service;

import java.util.List;

import com.tvoseguridadelectronica.oss.domain.Employee;



public interface EmployeeService {

	    List<Employee> findAll();
	    void delete(String id);
	    Employee findOne(String loginEmployee);
	    Employee findById(String id);
  
}
