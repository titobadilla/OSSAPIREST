package com.tvoseguridadelectronica.oss.restcontroller;

import java.util.ArrayList;
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

import com.tvoseguridadelectronica.oss.domain.Color;
import com.tvoseguridadelectronica.oss.jparepository.ColorJpaRepository;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping({ "/api/color" })
public class ColorRestController {
	@Autowired
	private ColorJpaRepository colorJpaRepository;
	
	@GetMapping("/")
	public ResponseEntity<List<Color>> listAllColors() {

		List<Color> colors=new ArrayList<>();
		try {
			colors= colorJpaRepository.findAll();		
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
		return new ResponseEntity<List<Color>>(colors, HttpStatus.OK);

	}
	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Color> createColor(@RequestBody final Color color) {

		colorJpaRepository.save(color);
		return new ResponseEntity<Color>(color, HttpStatus.NO_CONTENT);

	}
	
	@PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Color> editColor(@RequestBody final Color color) {

		colorJpaRepository.saveAndFlush(color);
		return new ResponseEntity<Color>(color, HttpStatus.OK);

	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Color> findColorById(@PathVariable("id") final Integer id ) {

		Color color = colorJpaRepository.findById(id).get();
		return new ResponseEntity<Color>(color, HttpStatus.OK);

	}	

	
	@DeleteMapping("/{id}")
	public ResponseEntity<Color> deleteColor(@PathVariable("id") final Integer id) {
		
		try {
			colorJpaRepository.deleteById(id);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error de borrado, por llave foranea");
			
		}
		

		return new ResponseEntity<Color>(HttpStatus.NO_CONTENT);
	}

}
