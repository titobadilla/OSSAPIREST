package com.tvoseguridadelectronica.oss.restcontroller;

import com.tvoseguridadelectronica.oss.domain.InventoryCategory;
import com.tvoseguridadelectronica.oss.jparepository.InventoryCategoryJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping({"api/inventoryCategory"})
public class InventoryCategoryRestController {

    @Autowired
    private InventoryCategoryJpaRepository inventoryCategoryJpaRepository;

    @GetMapping("/")
    public ResponseEntity<List<InventoryCategory>> listAllInventoryCategory() {

        List <InventoryCategory> categories = inventoryCategoryJpaRepository.findAll();
        return  new ResponseEntity<List<InventoryCategory>>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryCategory> getInventoryCategoryById(@PathVariable("id") final Integer id) {

        InventoryCategory inventoryCategory = inventoryCategoryJpaRepository.findById(id).get();
        return new ResponseEntity<InventoryCategory>(inventoryCategory, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InventoryCategory> createInventoryCategory(@RequestBody final InventoryCategory inventoryCategory) {

        inventoryCategoryJpaRepository.save(inventoryCategory);
        return new ResponseEntity<InventoryCategory>(inventoryCategory, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InventoryCategory> updateInventoryCategory(@PathVariable("id") final Integer id, @RequestBody final InventoryCategory inventoryCategory){

        InventoryCategory currentInventoryCategory = inventoryCategoryJpaRepository.findById(id).get();

        currentInventoryCategory.setName(inventoryCategory.getName());

        inventoryCategoryJpaRepository.saveAndFlush(currentInventoryCategory);

        return new ResponseEntity<InventoryCategory>(currentInventoryCategory,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<InventoryCategory> deleteInventoryCategory(@PathVariable("id") final Integer id) {

        inventoryCategoryJpaRepository.deleteById(id);

        return new ResponseEntity<InventoryCategory>(HttpStatus.NO_CONTENT);
    }

}
