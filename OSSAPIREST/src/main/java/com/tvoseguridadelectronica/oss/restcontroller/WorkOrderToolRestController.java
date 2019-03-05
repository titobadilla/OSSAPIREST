package com.tvoseguridadelectronica.oss.restcontroller;

import java.sql.SQLException;
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

import com.tvoseguridadelectronica.oss.domain.Device;
import com.tvoseguridadelectronica.oss.domain.Tool;
import com.tvoseguridadelectronica.oss.domain.WorkOrder;
import com.tvoseguridadelectronica.oss.domain.WorkOrderDevice;
import com.tvoseguridadelectronica.oss.domain.WorkOrderDeviceId;
import com.tvoseguridadelectronica.oss.domain.WorkOrderTool;
import com.tvoseguridadelectronica.oss.domain.WorkOrderToolId;
import com.tvoseguridadelectronica.oss.jparepository.DeviceJpaRepository;
import com.tvoseguridadelectronica.oss.jparepository.WorkOrderDeviceJpaRepository;
import com.tvoseguridadelectronica.oss.jparepository.WorkOrderToolJpaRepository;
import com.tvoseguridadelectronica.oss.repository.DeviceDao;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping({"/api/workordertool"})
public class WorkOrderToolRestController {
	
	@Autowired
    private WorkOrderToolJpaRepository workOrderToolJpaRepository;

    @GetMapping("/")
    public ResponseEntity<List<WorkOrderTool>> listAllWorkOrderTools() {
        List<WorkOrderTool> workOrderTools = workOrderToolJpaRepository.findAll();
        return new ResponseEntity<List<WorkOrderTool>>(workOrderTools, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WorkOrderTool> createWorkOrderTools(@RequestBody final WorkOrderTool workOrderTool) {
    	workOrderToolJpaRepository.save(workOrderTool);
        return new ResponseEntity<WorkOrderTool>(workOrderTool, HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WorkOrderTool> editWorkOrderTool(@RequestBody final WorkOrderTool workOrderTool) {

    	workOrderToolJpaRepository.saveAndFlush(workOrderTool);
        return new ResponseEntity<WorkOrderTool>(workOrderTool, HttpStatus.OK);
    }

   
    @GetMapping("/{idWorkOrder}/{idTool}")
    public ResponseEntity<WorkOrderTool> findWorkOrderToolById(@PathVariable("idWorkOrder") final int idWorkOrder,
    		@PathVariable("idTool") final int idTool) {
    	Tool tool=new Tool();
    	tool.setId(idTool);
    	WorkOrder workOrder=new WorkOrder();
    	workOrder.setId(idWorkOrder);
    	
    	WorkOrderTool workOrderTool = workOrderToolJpaRepository.findById(new WorkOrderToolId(workOrder,tool)).get();
        return new ResponseEntity<WorkOrderTool>(workOrderTool, HttpStatus.OK);
    }

    @DeleteMapping("/{idWorkOrder}/{idTool}")
    public ResponseEntity<WorkOrderTool> deleteWorkOrderTool(@PathVariable("idWorkOrder") final int idWorkOrder,
    		@PathVariable("idTool") final int idTool) {
    	Tool tool=new Tool();
    	tool.setId(idTool);
    	WorkOrder workOrder=new WorkOrder();
    	workOrder.setId(idWorkOrder);
    	
    	workOrderToolJpaRepository.deleteById(new WorkOrderToolId(workOrder,tool));
        return new ResponseEntity<WorkOrderTool>(HttpStatus.NO_CONTENT);
    }
    
}
