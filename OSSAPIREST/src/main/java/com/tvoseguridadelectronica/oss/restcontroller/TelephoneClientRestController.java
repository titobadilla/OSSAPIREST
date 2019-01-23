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

import com.tvoseguridadelectronica.oss.domain.TelephoneClient;
import com.tvoseguridadelectronica.oss.jparepository.TelephoneClientJpaRepository;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping({"/api/telephoneclient"})
public class TelephoneClientRestController {
	
	@Autowired
	private TelephoneClientJpaRepository telephoneClientJpaRepository;
	
	@GetMapping("/")
	public ResponseEntity<List<TelephoneClient>> listAllTelephones() {

		List<TelephoneClient> telephones = telephoneClientJpaRepository.findAll();
		return new ResponseEntity<List<TelephoneClient>>(telephones, HttpStatus.OK);

	}
	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TelephoneClient> createTelephone(@RequestBody final TelephoneClient telephone) {

		telephoneClientJpaRepository.save(telephone);
		return new ResponseEntity<TelephoneClient>(telephone, HttpStatus.NO_CONTENT);

	}
	
	@PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TelephoneClient> editTelephone(@RequestBody final TelephoneClient telephone) {

		telephoneClientJpaRepository.saveAndFlush(telephone);
		return new ResponseEntity<TelephoneClient>(telephone, HttpStatus.OK);

	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<TelephoneClient> findTelephoneById(@PathVariable("id") final Integer id ) {

		TelephoneClient telephone = telephoneClientJpaRepository.findById(id).get();
		return new ResponseEntity<TelephoneClient>(telephone, HttpStatus.OK);

	}	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<TelephoneClient> deleteTelephone(@PathVariable("id") final Integer id) {
		telephoneClientJpaRepository.deleteById(id);

		return new ResponseEntity<TelephoneClient>(HttpStatus.NO_CONTENT);
	}

}
