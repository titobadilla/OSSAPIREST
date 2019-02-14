package com.tvoseguridadelectronica.oss.restcontroller;

import com.tvoseguridadelectronica.oss.domain.WorkOrder;
import com.tvoseguridadelectronica.oss.jparepository.WorkOrderJpaRepository;
import com.tvoseguridadelectronica.oss.repository.WorkOrderDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping({"/api/workorder"})
public class WorkOrderRestController {

    @Autowired
    private WorkOrderJpaRepository workOrderJpaRepository;
    @Autowired
    private WorkOrderDao workOrderDao;

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
        
        workOrderJpaRepository.saveAndFlush(workOrder);
        
        return new ResponseEntity<WorkOrder>(workOrder, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<WorkOrder> findWorkOrderById(@PathVariable("id") final int id ) {

        WorkOrder workOrder = workOrderJpaRepository.findById(id).get();
        return new ResponseEntity<WorkOrder>(workOrder, HttpStatus.OK);

    }
    
    @GetMapping("/findworkorderbystartdate/{date}")
    public ResponseEntity<List<WorkOrder>> findWorkOrderByStartDate(@PathVariable("date") final String date ) {

        List<WorkOrder> workOrder = workOrderDao.findWorkOrdersByStartDateLike(date);
        return new ResponseEntity<List<WorkOrder>>(workOrder, HttpStatus.OK);

    }
    
    @GetMapping("/findworkorderbyweekwithstartdateandenddate/{dateStart}/{dateEnd}")
    public ResponseEntity<List<WorkOrder>> findWorkOrderByWeek(@PathVariable("dateStart") final String dateStart,
    		@PathVariable("dateEnd") final String dateEnd) {

        List<WorkOrder> workOrder = workOrderDao.findWorkOrdersByWeekWithStartDateAndEndDateLike(dateStart,dateEnd);
        return new ResponseEntity<List<WorkOrder>>(workOrder, HttpStatus.OK);

    }
    
    @GetMapping("/findworkorderbymonthandyear/{date}")
    public ResponseEntity<List<WorkOrder>> findWorkOrderByMonth(@PathVariable("date") final String date ) {

        List<WorkOrder> workOrder = workOrderDao.findWorkOrdersByMonthAndYear(date);
        return new ResponseEntity<List<WorkOrder>>(workOrder, HttpStatus.OK);

    }
    


    @DeleteMapping("/{id}")
    public ResponseEntity<WorkOrder> deleteWorkOrder(@PathVariable("id") final int id) {
        workOrderJpaRepository.deleteById(id);
        return new ResponseEntity<WorkOrder>(HttpStatus.NO_CONTENT);
    }
}
