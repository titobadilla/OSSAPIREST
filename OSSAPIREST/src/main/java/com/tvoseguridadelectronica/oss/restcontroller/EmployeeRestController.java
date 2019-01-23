package com.tvoseguridadelectronica.oss.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tvoseguridadelectronica.oss.domain.Employee;
import com.tvoseguridadelectronica.oss.jparepository.EmployeeJpaRepository;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping({ "/api/employee" })
public class EmployeeRestController {
	
	@Autowired
	private EmployeeJpaRepository employeeJpaRepository;
	
	@GetMapping("/")
	public ResponseEntity<List<Employee>> listAllEmployees() {

		List<Employee> employees = employeeJpaRepository.findAll();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);

	}
	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> createEmployee(@RequestBody final Employee employee) {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(employee.getPassword());
		employee.setPassword(hashedPassword);
		
		employeeJpaRepository.save(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.NO_CONTENT);

	}
	
	@PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> editEmployee(@RequestBody final Employee employee) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(employee.getPassword());
		employee.setPassword(hashedPassword);
		employeeJpaRepository.saveAndFlush(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);

	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> findEmployeeById(@PathVariable("id") final String id ) {

		Employee employee = employeeJpaRepository.findById(id).get();
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);

	}	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") final String id) {
		employeeJpaRepository.deleteById(id);

		return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
	}

}
