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
import com.tvoseguridadelectronica.oss.domain.WorkOrderDevice;
import com.tvoseguridadelectronica.oss.domain.WorkOrderDeviceId;
import com.tvoseguridadelectronica.oss.jparepository.DeviceJpaRepository;
import com.tvoseguridadelectronica.oss.jparepository.WorkOrderDeviceJpaRepository;
import com.tvoseguridadelectronica.oss.repository.DeviceDao;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping({"/api/workorderdevice"})
public class WorkOrderDeviceRestController {
	
	@Autowired
    private WorkOrderDeviceJpaRepository workOrderDeviceJpaRepository;

    @GetMapping("/")
    public ResponseEntity<List<WorkOrderDevice>> listAllWorkOrderDevices() {
        List<WorkOrderDevice> workOrderDevices = workOrderDeviceJpaRepository.findAll();
        return new ResponseEntity<List<WorkOrderDevice>>(workOrderDevices, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WorkOrderDevice> createWorkOrderDevice(@RequestBody final WorkOrderDevice workOrderDevice) {
    	workOrderDeviceJpaRepository.save(workOrderDevice);
        return new ResponseEntity<WorkOrderDevice>(workOrderDevice, HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WorkOrderDevice> editWorkOrderDevice(@RequestBody final WorkOrderDevice workOrderDevice) {

    	workOrderDeviceJpaRepository.saveAndFlush(workOrderDevice);
        return new ResponseEntity<WorkOrderDevice>(workOrderDevice, HttpStatus.OK);
    }

   
    @GetMapping("/{idWorkOrder}/{idDevice}")
    public ResponseEntity<WorkOrderDevice> findWorkOrderDeviceById(@PathVariable("idWorkOrder") final int idWorkOrder,
    		@PathVariable("idDevice") final int idDevice ) {
    	
    	WorkOrderDevice workOrderDevice = workOrderDeviceJpaRepository.findById(new WorkOrderDeviceId(idWorkOrder,idDevice)).get();
        return new ResponseEntity<WorkOrderDevice>(workOrderDevice, HttpStatus.OK);
    }

    @DeleteMapping("/{idWorkOrder}/{idDevice}")
    public ResponseEntity<WorkOrderDevice> deleteWorkOrderDevice(@PathVariable("idWorkOrder") final int idWorkOrder,
    		@PathVariable("idDevice") final int idDevice) {
    	workOrderDeviceJpaRepository.deleteById(new WorkOrderDeviceId(idWorkOrder,idDevice));
        return new ResponseEntity<WorkOrderDevice>(HttpStatus.NO_CONTENT);
    }

}
