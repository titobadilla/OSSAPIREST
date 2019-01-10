package com.tvoseguridadelectronica.oss.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tvoseguridadelectronica.oss.domain.TelephoneEmployee;
import com.tvoseguridadelectronica.oss.jparepository.TelephoneEmployeeJpaRepository;

@RestController
@RequestMapping({"/api/telephoneemployee"})
public class TelephoneEmployeeRestController {
	
	@Autowired
	private TelephoneEmployeeJpaRepository telephoneEmployeeJpaRepository;
	
	@GetMapping("/")
	public ResponseEntity<List<TelephoneEmployee>> listAllTelephones() {

		List<TelephoneEmployee> telephones = telephoneEmployeeJpaRepository.findAll();
		return new ResponseEntity<List<TelephoneEmployee>>(telephones, HttpStatus.OK);

	}
	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TelephoneEmployee> createTelephone(@RequestBody final TelephoneEmployee telephone) {

		telephoneEmployeeJpaRepository.save(telephone);
		return new ResponseEntity<TelephoneEmployee>(telephone, HttpStatus.NO_CONTENT);

	}
	
	@PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TelephoneEmployee> editTelephone(@RequestBody final TelephoneEmployee telephone) {

		telephoneEmployeeJpaRepository.saveAndFlush(telephone);
		return new ResponseEntity<TelephoneEmployee>(telephone, HttpStatus.OK);

	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<TelephoneEmployee> findTelephoneById(@PathVariable("id") final Integer id ) {

		TelephoneEmployee telephone = telephoneEmployeeJpaRepository.findById(id).get();
		return new ResponseEntity<TelephoneEmployee>(telephone, HttpStatus.OK);

	}	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<TelephoneEmployee> deleteTelephone(@PathVariable("id") final Integer id) {
		telephoneEmployeeJpaRepository.deleteById(id);

		return new ResponseEntity<TelephoneEmployee>(HttpStatus.NO_CONTENT);
	}

}
