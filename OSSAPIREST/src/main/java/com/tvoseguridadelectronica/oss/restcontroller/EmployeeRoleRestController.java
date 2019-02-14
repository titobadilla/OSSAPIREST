package com.tvoseguridadelectronica.oss.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tvoseguridadelectronica.oss.domain.EmployeeRole;
import com.tvoseguridadelectronica.oss.jparepository.EmployeeRoleJpaRepository;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping({ "/api/employeerole" })
public class EmployeeRoleRestController {
	
	@Autowired
	private EmployeeRoleJpaRepository employeeRoleJpaRepository;
	
	@GetMapping("/")
	public ResponseEntity<List<EmployeeRole>> listAllEmployeeRoles() {

		List<EmployeeRole> employeeRoles = employeeRoleJpaRepository.findAll();
		return new ResponseEntity<List<EmployeeRole>>(employeeRoles, HttpStatus.OK);

	}
	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeRole> createEmployeeRole(@RequestBody final EmployeeRole employeeRole) {

		employeeRoleJpaRepository.save(employeeRole);
		return new ResponseEntity<EmployeeRole>(employeeRole, HttpStatus.NO_CONTENT);

	}
	
	@PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeRole> editEmployeeRole(@RequestBody final EmployeeRole employeeRole) {

		employeeRoleJpaRepository.saveAndFlush(employeeRole);
		return new ResponseEntity<EmployeeRole>(employeeRole, HttpStatus.OK);

	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeRole> findEmployeeRoleById(@PathVariable("id") final Integer id ) {

		EmployeeRole employeeRole = employeeRoleJpaRepository.findById(id).get();
		return new ResponseEntity<EmployeeRole>(employeeRole, HttpStatus.OK);

	}	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<EmployeeRole> deleteEmployeeRole(@PathVariable("id") final Integer id) {
		employeeRoleJpaRepository.deleteById(id);

		return new ResponseEntity<EmployeeRole>(HttpStatus.NO_CONTENT);
	}

}
