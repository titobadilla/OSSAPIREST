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

import com.tvoseguridadelectronica.oss.domain.Address;
import com.tvoseguridadelectronica.oss.jparepository.AddressJpaRepository;

@RestController
@RequestMapping({ "/api/address" })
public class AddressRestController {
	
	@Autowired
	private AddressJpaRepository addressJpaRepository;
	
	@GetMapping("/")
	public ResponseEntity<List<Address>> listAllAddresses() {

		List<Address> address = addressJpaRepository.findAll();
		return new ResponseEntity<List<Address>>(address, HttpStatus.OK);

	}
	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Address> createAddress(@RequestBody final Address address) {

		addressJpaRepository.save(address);
		return new ResponseEntity<Address>(address, HttpStatus.NO_CONTENT);

	}
	
	@PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Address> editAddress(@RequestBody final Address address) {

		addressJpaRepository.saveAndFlush(address);
		return new ResponseEntity<Address>(address, HttpStatus.OK);

	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Address> findAddressById(@PathVariable("id") final Integer id ) {

		Address address = addressJpaRepository.findById(id).get();
		return new ResponseEntity<Address>(address, HttpStatus.OK);

	}	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Address> deleteAddress(@PathVariable("id") final Integer id) {
		addressJpaRepository.deleteById(id);

		return new ResponseEntity<Address>(HttpStatus.NO_CONTENT);
	}

}
