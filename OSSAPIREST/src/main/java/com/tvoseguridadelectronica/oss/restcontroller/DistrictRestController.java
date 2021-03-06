package com.tvoseguridadelectronica.oss.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tvoseguridadelectronica.oss.domain.District;
import com.tvoseguridadelectronica.oss.jparepository.DistrictJpaRepository;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping({"/api/district"})
public class DistrictRestController {
	
	
	@Autowired
	DistrictJpaRepository districtJpaRepository;
	
	 @GetMapping("/")
	    public ResponseEntity<List<District>> listAllDeviceState() {
	        List<District> districts = districtJpaRepository.findAll();
	        return new ResponseEntity<List<District>>(districts, HttpStatus.OK);
	    }
	 
	 
	  @GetMapping("/districtbyprovinceandcanton/{idProvince}/{idCanton}")
	    public ResponseEntity<List<District>> findCDistrictByProvinceAndCanton(@PathVariable("idProvince") final String idProvince,
	    		@PathVariable("idCanton") final String idCanton) {
	    	
	    	List<District> districts = 
	    	districtJpaRepository.findByDistrictIdCantonCantonIdProvinceIdAndDistrictIdCantonCantonIdId(idProvince, idCanton);
	    	
	        return new ResponseEntity<List<District>>(districts, HttpStatus.OK);
	    }

}
