package com.tvoseguridadelectronica.oss.restcontroller;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonNullFormatVisitor;
import com.tvoseguridadelectronica.oss.domain.Client;
import com.tvoseguridadelectronica.oss.jparepository.ClientJpaRepository;
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
import com.tvoseguridadelectronica.oss.domain.GroupClient;
import com.tvoseguridadelectronica.oss.jparepository.GroupClientJpaRepository;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping({ "/api/groupclient" })
public class GroupClientRestController {
	
	@Autowired
	private GroupClientJpaRepository groupClientJpaRepository;

	@Autowired
	private ClientJpaRepository clientJpaRepository;
	
	@GetMapping("/")
	public ResponseEntity<List<GroupClient>> listAllGroupsClient(){

		List<GroupClient> groupsClient = groupClientJpaRepository.findAll();
		return new ResponseEntity<List<GroupClient>>(groupsClient, HttpStatus.OK);

	}
	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GroupClient> createGroupClient(@RequestBody final GroupClient groupClient) {

		groupClientJpaRepository.save(groupClient);
		return new ResponseEntity<GroupClient>(groupClient, HttpStatus.NO_CONTENT);

	}
	
	@PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GroupClient> editGroupClient(@RequestBody final GroupClient groupClient) {

		groupClientJpaRepository.saveAndFlush(groupClient);
		return new ResponseEntity<GroupClient>(groupClient, HttpStatus.OK);

	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<GroupClient> findGroupClientById(@PathVariable("id") final Integer id ) {

		GroupClient groupClient = groupClientJpaRepository.findById(id).get();
		return new ResponseEntity<GroupClient>(groupClient, HttpStatus.OK);

	}	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<GroupClient> deleteGroupClient(@PathVariable("id") final Integer id) {
		groupClientJpaRepository.deleteById(id);
		return new ResponseEntity<GroupClient>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/headClients")
	public ResponseEntity<List<Client>> listAllHeadClient(){

		List<GroupClient> groupsClient = groupClientJpaRepository.findAll();
		List<Client> headClients = new ArrayList<Client>();

			int lenght = groupsClient.size()-1;
		for (int i = 0; i <=lenght ; i++) {
			Client client = clientJpaRepository.findById(groupsClient.get(i).getIdHeadClient()).get();
			headClients.add(client);
		}
		return new ResponseEntity<List<Client>>(headClients, HttpStatus.OK);

	}

	@GetMapping("/clientsOfheadClients/{id}")
	public ResponseEntity<List<Client>> findClientsOfHeadClient(@PathVariable("id") final String id ) {

		GroupClient groupClient = groupClientJpaRepository.getGroupClientByIdHeadClient(id);
		return new ResponseEntity<List<Client>>(groupClient.getClients(), HttpStatus.OK);
	}


}
