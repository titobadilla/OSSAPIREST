package com.tvoseguridadelectronica.oss.restcontroller;

import com.tvoseguridadelectronica.oss.domain.Material;
import com.tvoseguridadelectronica.oss.jparepository.MaterialJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/material"})
public class MaterialRestController {

    @Autowired
    private MaterialJpaRepository materialJpaRepository;

    @GetMapping("/")
    public ResponseEntity<List<Material>> listAllMaterial() {
        List<Material> materials = materialJpaRepository.findAll();
        return new ResponseEntity<List<Material>>(materials, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Material> createMaterial(@RequestBody final Material material) {
        materialJpaRepository.save(material);
        return new ResponseEntity<Material>(material, HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Material> editMaterial(@RequestBody final Material material) {
        materialJpaRepository.saveAndFlush(material);
        return new ResponseEntity<Material>(material, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Material> findMaterialById(@PathVariable("id") final int id ) {
        Material material = materialJpaRepository.findById(id).get();
        return new ResponseEntity<Material>(material, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Material> deleteMaterial(@PathVariable("id") final int id) {
        materialJpaRepository.deleteById(id);
        return new ResponseEntity<Material>(HttpStatus.NO_CONTENT);
    }
}
