package com.tvoseguridadelectronica.oss.restcontroller;

import com.tvoseguridadelectronica.oss.domain.WorkOrder;
import com.tvoseguridadelectronica.oss.jparepository.WorkOrderJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping({"/api/workorder"})
public class WorkOrderRestController {

    @Autowired
    private WorkOrderJpaRepository workOrderJpaRepository;

    @GetMapping("/")
    public ResponseEntity<List<WorkOrder>> listAllWorkOrder() {
        List<WorkOrder> workOrders = workOrderJpaRepository.findAll();
        return new ResponseEntity<List<WorkOrder>>(workOrders, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WorkOrder> createWorkOrder(@RequestBody final WorkOrder workOrder) {
        workOrderJpaRepository.save(workOrder);
        return new ResponseEntity<WorkOrder>(workOrder, HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WorkOrder> editWorkOrder(@PathVariable("id") final Integer id,@RequestBody final WorkOrder workOrder) {

        WorkOrder workOrder2 = workOrderJpaRepository.findById(id).get();

        workOrder2.setDescription(workOrder.getDescription());
        workOrder2.setClient(workOrder.getClient());
        workOrder2.setEmployees(workOrder.getEmployees());
        workOrder2.setListWorkOrder(workOrder.getListWorkOrder());
        //workOrder2.setWorkOrderDetail(workOrder.getWorkOrderDetail());
        workOrder2.setWorkOrderType(workOrder.getWorkOrderType());
        
        workOrderJpaRepository.saveAndFlush(workOrder2);
        
        return new ResponseEntity<WorkOrder>(workOrder2, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<WorkOrder> findWorkOrderById(@PathVariable("id") final int id ) {

        WorkOrder workOrder = workOrderJpaRepository.findById(id).get();
        return new ResponseEntity<WorkOrder>(workOrder, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WorkOrder> deleteWorkOrder(@PathVariable("id") final int id) {
        workOrderJpaRepository.deleteById(id);
        return new ResponseEntity<WorkOrder>(HttpStatus.NO_CONTENT);
    }
}
