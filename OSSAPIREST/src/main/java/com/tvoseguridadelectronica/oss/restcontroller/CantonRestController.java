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

import com.tvoseguridadelectronica.oss.domain.Canton;
import com.tvoseguridadelectronica.oss.domain.CantonId;
import com.tvoseguridadelectronica.oss.jparepository.CantonJpaRepository;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping({"/api/canton"})
public class CantonRestController {
	
	@Autowired
	CantonJpaRepository cantonJpaRepository;
	
	
	 @GetMapping("/")
	    public ResponseEntity<List<Canton>> listAllCantons() {
	        List<Canton> deviceStates = cantonJpaRepository.findAll();
	        return new ResponseEntity<List<Canton>>(deviceStates, HttpStatus.OK);
	    }

	    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Canton> createCanton(@RequestBody final Canton canton) {
	    	cantonJpaRepository.save(canton);
	        return new ResponseEntity<Canton>(canton, HttpStatus.NO_CONTENT);
	    }

	    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Canton> editCanton(@RequestBody final Canton canton) {
	    	cantonJpaRepository.saveAndFlush(canton);
	        return new ResponseEntity<Canton>(canton, HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Canton> findCantonById(@PathVariable("id") final CantonId id ) {
	    	Canton canton = cantonJpaRepository.findById(id).get();
	        return new ResponseEntity<Canton>(canton, HttpStatus.OK);
	    }
	    
	    @GetMapping("/cantonsbyprovince/{id}")
	    public ResponseEntity<List<Canton>> findCantonByProvince(@PathVariable("id") final String id ) {
	    	
	    	List<Canton> canton = cantonJpaRepository.findByCantonIdProvinceId(id);
	        return new ResponseEntity<List<Canton>>(canton, HttpStatus.OK);
	    }


	    @DeleteMapping("/{id}")
	    public ResponseEntity<Canton> deleteCanton(@PathVariable("id") final CantonId id) {
	    	cantonJpaRepository.deleteById(id);
	        return new ResponseEntity<Canton>(HttpStatus.NO_CONTENT);
	    }
	

}
