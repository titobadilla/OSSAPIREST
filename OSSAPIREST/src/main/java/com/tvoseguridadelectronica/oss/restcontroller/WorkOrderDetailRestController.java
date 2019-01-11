package com.tvoseguridadelectronica.oss.restcontroller;

import com.tvoseguridadelectronica.oss.domain.WorkOrderDetail;
import com.tvoseguridadelectronica.oss.jparepository.WorkOrderDetailJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"api/workOrderDetail"})
public class WorkOrderDetailRestController {

    @Autowired
    private WorkOrderDetailJpaRepository workOrderDetailJpaRepository;

    @GetMapping("/")
    public ResponseEntity<List<WorkOrderDetail>> listAllWorkOrderDetail() {

        List <WorkOrderDetail> categories = workOrderDetailJpaRepository.findAll();
        return  new ResponseEntity<List<WorkOrderDetail>>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkOrderDetail> getWorkOrderDetailById(@PathVariable("id") final Integer id) {

        WorkOrderDetail WorkOrderDetail = workOrderDetailJpaRepository.findById(id).get();
        return new ResponseEntity<WorkOrderDetail>(WorkOrderDetail, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WorkOrderDetail> createWorkOrderDetail(@RequestBody final WorkOrderDetail workOrderDetail) {

        workOrderDetailJpaRepository.save(workOrderDetail);
        return new ResponseEntity<WorkOrderDetail>(workOrderDetail, HttpStatus.CREATED);
    }

    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WorkOrderDetail> editWorkOrderDetail(@RequestBody final WorkOrderDetail workOrderDetail) {

        workOrderDetailJpaRepository.saveAndFlush(workOrderDetail);
        return new ResponseEntity<WorkOrderDetail>(workOrderDetail, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WorkOrderDetail> deleteWorkOrderDetail(@PathVariable("id") final Integer id) {

        workOrderDetailJpaRepository.deleteById(id);

        return new ResponseEntity<WorkOrderDetail>(HttpStatus.NO_CONTENT);
    }

}
