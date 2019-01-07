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

import com.tvoseguridadelectronica.oss.domain.Telephone;
import com.tvoseguridadelectronica.oss.jparepository.TelephoneJpaRepository;

@RestController
@RequestMapping({"/api/telephone"})
public class TelephoneRestController {
	
	@Autowired
	private TelephoneJpaRepository telephoneJpaRepository;
	
	@GetMapping("/")
	public ResponseEntity<List<Telephone>> listAllTelephones() {

		List<Telephone> telephones = telephoneJpaRepository.findAll();
		return new ResponseEntity<List<Telephone>>(telephones, HttpStatus.OK);

	}
	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Telephone> createTelephone(@RequestBody final Telephone telephone) {

		telephoneJpaRepository.save(telephone);
		return new ResponseEntity<Telephone>(telephone, HttpStatus.NO_CONTENT);

	}
	
	@PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Telephone> editTelephone(@RequestBody final Telephone telephone) {

		telephoneJpaRepository.saveAndFlush(telephone);
		return new ResponseEntity<Telephone>(telephone, HttpStatus.OK);

	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Telephone> findTelephoneById(@PathVariable("id") final Integer id ) {

		Telephone telephone = telephoneJpaRepository.findById(id).get();
		return new ResponseEntity<Telephone>(telephone, HttpStatus.OK);

	}	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Telephone> deleteTelephone(@PathVariable("id") final Integer id) {
		telephoneJpaRepository.deleteById(id);

		return new ResponseEntity<Telephone>(HttpStatus.NO_CONTENT);
	}

}
