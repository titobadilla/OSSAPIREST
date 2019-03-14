package com.tvoseguridadelectronica.oss.restcontroller;

import com.tvoseguridadelectronica.oss.domain.Model;
import com.tvoseguridadelectronica.oss.jparepository.ModelJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping({"api/model"})
public class ModelRestController {

    @Autowired
    private ModelJpaRepository modelJpaRepository;

    @GetMapping("/")
    public ResponseEntity<List<Model>>listAllModels() {

        List <Model> models = modelJpaRepository.findAll();
        return  new ResponseEntity<List<Model>>(models, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Model> getModelById(@PathVariable("id") final Integer id) {

        Model model = modelJpaRepository.findById(id).get();
        return new ResponseEntity<Model>(model, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Model> createModel(@RequestBody final Model model) {

        modelJpaRepository.save(model);
        return new ResponseEntity<Model>(model, HttpStatus.CREATED);
    }

    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Model> updateModel(@RequestBody final Model model){

        modelJpaRepository.saveAndFlush(model);

        return new ResponseEntity<Model>(model,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Model> deleteModel(@PathVariable("id") final Integer id) {

        modelJpaRepository.deleteById(id);

        return new ResponseEntity<Model>(HttpStatus.NO_CONTENT);
    }
}
