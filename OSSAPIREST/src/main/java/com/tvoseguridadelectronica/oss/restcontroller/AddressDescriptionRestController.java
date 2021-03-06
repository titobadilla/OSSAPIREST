package com.tvoseguridadelectronica.oss.restcontroller;

import com.tvoseguridadelectronica.oss.domain.AddressDescription;
import com.tvoseguridadelectronica.oss.jparepository.AddressDescriptionJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping({"/api/addressdescription"})
public class AddressDescriptionRestController {
    
    @Autowired
    private AddressDescriptionJpaRepository addressDescriptionJpaRepository;

    @GetMapping("/")
    public ResponseEntity<List<AddressDescription>> listAllAddressDescription() {
        List<AddressDescription> addressDescriptions = addressDescriptionJpaRepository.findAll();
        return new ResponseEntity<List<AddressDescription>>(addressDescriptions, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddressDescription> createAddressDescription(@RequestBody final AddressDescription addressDescription) {
        addressDescriptionJpaRepository.save(addressDescription);
        return new ResponseEntity<AddressDescription>(addressDescription, HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddressDescription> editAddressDescription(@PathVariable("id") final Integer id,@RequestBody final AddressDescription addressDescription) {

        

        addressDescriptionJpaRepository.saveAndFlush(addressDescription);
        return new ResponseEntity<AddressDescription>(addressDescription, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDescription> findAddressDescriptionById(@PathVariable("id") final int id ) {
        AddressDescription addressDescription = addressDescriptionJpaRepository.findById(id).get();
        return new ResponseEntity<AddressDescription>(addressDescription, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AddressDescription> deleteAddressDescription(@PathVariable("id") final int id) {
        addressDescriptionJpaRepository.deleteById(id);
        return new ResponseEntity<AddressDescription>(HttpStatus.NO_CONTENT);
    }
}
