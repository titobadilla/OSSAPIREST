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
import com.tvoseguridadelectronica.oss.domain.Material;
import com.tvoseguridadelectronica.oss.domain.Tool;
import com.tvoseguridadelectronica.oss.domain.WorkOrder;
import com.tvoseguridadelectronica.oss.domain.WorkOrderDevice;
import com.tvoseguridadelectronica.oss.domain.WorkOrderDeviceId;
import com.tvoseguridadelectronica.oss.domain.WorkOrderMaterial;
import com.tvoseguridadelectronica.oss.domain.WorkOrderMaterialId;
import com.tvoseguridadelectronica.oss.jparepository.DeviceJpaRepository;
import com.tvoseguridadelectronica.oss.jparepository.WorkOrderDeviceJpaRepository;
import com.tvoseguridadelectronica.oss.jparepository.WorkOrderMaterialJpaRepository;
import com.tvoseguridadelectronica.oss.repository.DeviceDao;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping({"/api/workordermaterial"})
public class WorkOrderMaterialRestController {
	
	@Autowired
    private WorkOrderMaterialJpaRepository workOrderMaterialJpaRepository;


    @GetMapping("/")
    public ResponseEntity<List<WorkOrderMaterial>> listAllWorkOrderMaterials() {
        List<WorkOrderMaterial> workOrderMaterials = workOrderMaterialJpaRepository.findAll();
        return new ResponseEntity<List<WorkOrderMaterial>>(workOrderMaterials, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WorkOrderMaterial> createWorkOrderMaterial(@RequestBody final WorkOrderMaterial workOrderMaterial) {
    	workOrderMaterialJpaRepository.save(workOrderMaterial);
        return new ResponseEntity<WorkOrderMaterial>(workOrderMaterial, HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WorkOrderMaterial> editWorkOrderMaterial(@RequestBody final WorkOrderMaterial workOrderMaterial) {

    	workOrderMaterialJpaRepository.saveAndFlush(workOrderMaterial);
        return new ResponseEntity<WorkOrderMaterial>(workOrderMaterial, HttpStatus.OK);
    }

   
    @GetMapping("/{idWorkOrder}/{idMaterial}")
    public ResponseEntity<WorkOrderMaterial> findWorkOrderMaterialById(@PathVariable("idWorkOrder") final int idWorkOrder,
    		@PathVariable("idMaterial") final int idMaterial ) {
    	
    	Material material=new Material();
    	material.setId(idMaterial);
    	WorkOrder workOrder=new WorkOrder();
    	workOrder.setId(idWorkOrder);
    	
    	WorkOrderMaterial workOrderDevice = workOrderMaterialJpaRepository.findById(new WorkOrderMaterialId(workOrder,material)).get();
        return new ResponseEntity<WorkOrderMaterial>(workOrderDevice, HttpStatus.OK);
    }

    @DeleteMapping("/{idWorkOrder}/{idMaterial}")
    public ResponseEntity<WorkOrderMaterial> deleteWorkOrderMaterial(@PathVariable("idWorkOrder") final int idWorkOrder,
    		@PathVariable("idMaterial") final int idMaterial) {
    	Material material=new Material();
    	material.setId(idMaterial);
    	WorkOrder workOrder=new WorkOrder();
    	workOrder.setId(idWorkOrder);
    	
    	workOrderMaterialJpaRepository.deleteById(new WorkOrderMaterialId(workOrder,material));
        return new ResponseEntity<WorkOrderMaterial>(HttpStatus.NO_CONTENT);
    }
    
}
