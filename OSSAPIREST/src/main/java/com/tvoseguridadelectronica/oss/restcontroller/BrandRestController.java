package com.tvoseguridadelectronica.oss.restcontroller;

import com.tvoseguridadelectronica.oss.domain.Brand;
import com.tvoseguridadelectronica.oss.domain.Model;
import com.tvoseguridadelectronica.oss.jparepository.BrandJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping({"api/brand"})
public class BrandRestController {

    @Autowired
    private BrandJpaRepository brandJpaRepository;

    @GetMapping("/")
    public ResponseEntity<List<Brand>> listAllBrands() {

        List <Brand> brands = brandJpaRepository.findAll();
        return  new ResponseEntity<List<Brand>>(brands, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable("id") final Integer id) {

        Brand brand = brandJpaRepository.findById(id).get();
        return new ResponseEntity<Brand>(brand, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Brand> createBrand(@RequestBody final Brand brand) {

        brandJpaRepository.save(brand);
        return new ResponseEntity<Brand>(brand, HttpStatus.CREATED);
    }

    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Brand> updateBrand(@RequestBody final Brand brand){

        brandJpaRepository.saveAndFlush(brand);

        return new ResponseEntity<Brand>(brand,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Brand> deleteModel(@PathVariable("id") final Integer id) {

        brandJpaRepository.deleteById(id);

        return new ResponseEntity<Brand>(HttpStatus.NO_CONTENT);
    }
}
