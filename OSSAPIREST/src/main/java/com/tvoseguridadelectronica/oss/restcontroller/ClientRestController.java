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
import com.tvoseguridadelectronica.oss.domain.Client;
import com.tvoseguridadelectronica.oss.jparepository.ClientJpaRepository;

@RestController
@RequestMapping({ "/api/client" })
public class ClientRestController {
	
	@Autowired
	private ClientJpaRepository clientJpaRepository;
	
	@GetMapping("/")
	public ResponseEntity<List<Client>> listAllClients() {

		List<Client> clients = clientJpaRepository.findAll();
		return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);

	}
	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> createClient(@RequestBody final Client client) {

		clientJpaRepository.save(client);
		return new ResponseEntity<Client>(client, HttpStatus.NO_CONTENT);

	}
	
	@PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> editClient(@RequestBody final Client client) {

		clientJpaRepository.saveAndFlush(client);
		return new ResponseEntity<Client>(client, HttpStatus.OK);

	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Client> findClientById(@PathVariable("id") final String id ) {

		Client client = clientJpaRepository.findById(id).get();
		return new ResponseEntity<Client>(client, HttpStatus.OK);

	}	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Client> deleteClient(@PathVariable("id") final String id) {
		clientJpaRepository.deleteById(id);

		return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
	}

}
