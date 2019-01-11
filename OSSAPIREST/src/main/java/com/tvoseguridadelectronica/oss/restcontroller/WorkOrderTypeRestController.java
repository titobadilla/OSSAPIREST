package com.tvoseguridadelectronica.oss.restcontroller;

import com.tvoseguridadelectronica.oss.domain.WorkOrderType;
import com.tvoseguridadelectronica.oss.jparepository.WorkOrderTypeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"api/workordertype"})
public class WorkOrderTypeRestController {
    
    @Autowired
    private WorkOrderTypeJpaRepository workOrderTypeJpaRepository;

    @GetMapping("/")
    public ResponseEntity<List<WorkOrderType>> listAllWorkOrderType() {

        List <WorkOrderType> workOrderTypes = workOrderTypeJpaRepository.findAll();
        return  new ResponseEntity<List<WorkOrderType>>(workOrderTypes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkOrderType> getWorkOrderTypeById(@PathVariable("id") final Integer id) {

        WorkOrderType WorkOrderType = workOrderTypeJpaRepository.findById(id).get();
        return new ResponseEntity<WorkOrderType>(WorkOrderType, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WorkOrderType> createWorkOrderType(@RequestBody final WorkOrderType workOrderType) {

        workOrderTypeJpaRepository.save(workOrderType);
        return new ResponseEntity<WorkOrderType>(workOrderType, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WorkOrderType> updateWorkOrderType(@PathVariable("id") final Integer id, @RequestBody final WorkOrderType workOrderType){

        WorkOrderType currentWorkOrderType = workOrderTypeJpaRepository.findById(id).get();

        currentWorkOrderType.setName(workOrderType.getName());

        workOrderTypeJpaRepository.saveAndFlush(currentWorkOrderType);

        return new ResponseEntity<WorkOrderType>(currentWorkOrderType,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WorkOrderType> deleteWorkOrderType(@PathVariable("id") final Integer id) {

        workOrderTypeJpaRepository.deleteById(id);

        return new ResponseEntity<WorkOrderType>(HttpStatus.NO_CONTENT);
    }
}
