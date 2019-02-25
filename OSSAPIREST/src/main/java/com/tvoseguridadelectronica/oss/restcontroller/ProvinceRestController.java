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

import com.tvoseguridadelectronica.oss.domain.Province;
import com.tvoseguridadelectronica.oss.jparepository.ProvinceJpaRepository;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping({"/api/province"})
public class ProvinceRestController {

	
	@Autowired
	ProvinceJpaRepository provinceJpaRepository;
	
	
	 @GetMapping("/")
	    public ResponseEntity<List<Province>> listAllProvinces() {
	        List<Province> provinces = provinceJpaRepository.findAll();
	        return new ResponseEntity<List<Province>>(provinces, HttpStatus.OK);
	    }

	    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Province> createProvince(@RequestBody final Province province) {
	    	provinceJpaRepository.save(province);
	        return new ResponseEntity<Province>(province, HttpStatus.NO_CONTENT);
	    }

	    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Province> editProvince(@RequestBody final Province province) {
	    	provinceJpaRepository.saveAndFlush(province);
	        return new ResponseEntity<Province>(province, HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Province> findProvinceById(@PathVariable("id") final String id ) {
	    	Province province = provinceJpaRepository.findById(id).get();
	        return new ResponseEntity<Province>(province, HttpStatus.OK);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Province> deleteProvince(@PathVariable("id") final String id) {
	    	provinceJpaRepository.deleteById(id);
	        return new ResponseEntity<Province>(HttpStatus.NO_CONTENT);
	    }
}
