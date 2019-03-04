package com.tvoseguridadelectronica.oss.restcontroller;

import com.tvoseguridadelectronica.oss.domain.SuppliesDevice;
import com.tvoseguridadelectronica.oss.domain.SuppliesDeviceId;
import com.tvoseguridadelectronica.oss.jparepository.SuppliesDeviceJpaRepository;
import com.tvoseguridadelectronica.oss.repository.SuppliesDeviceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


//@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping({"api/suppliesdevice"})
public class SuppliesDeviceRestController {

    private SuppliesDeviceJpaRepository SuppliesDeviceJpaRepository;
    private SuppliesDeviceDao SuppliesDeviceDao;

    @Autowired
    public void setListDevice(SuppliesDeviceJpaRepository SuppliesDeviceJpaRepository, SuppliesDeviceDao SuppliesDeviceDao) {
        this.SuppliesDeviceJpaRepository = SuppliesDeviceJpaRepository;
        this.SuppliesDeviceDao = SuppliesDeviceDao;
    }
    
    @GetMapping("/")
    public ResponseEntity<List<SuppliesDevice>> listAllSuppliesDevices() {

        List <SuppliesDevice> SuppliesDevices = SuppliesDeviceJpaRepository.findAll();
        return  new ResponseEntity<List<SuppliesDevice>>(SuppliesDevices, HttpStatus.OK);
    }

    @GetMapping("/{idDevice}/{idListWorkOrder}")
    public ResponseEntity<SuppliesDevice> getSuppliesDeviceById(@PathVariable("idDevice") final int deviceId, @PathVariable("idListWorkOrder") final int listWorkOrderId) {

        SuppliesDeviceId id = new SuppliesDeviceId( );
        id.getDevice().setId(deviceId);
        id.getListWorkOrder().setId(listWorkOrderId);

        SuppliesDevice SuppliesDevice = SuppliesDeviceJpaRepository.findById(id).get();
        return new ResponseEntity<SuppliesDevice>(SuppliesDevice, HttpStatus.OK);
    }

    @GetMapping("/findByIdList/{id}")
    public ResponseEntity<List<SuppliesDevice>> getListDeviceByIdListWorkOrder(@PathVariable("id") final int id) throws SQLException {

        List<SuppliesDevice> SuppliesDevices = SuppliesDeviceDao.findByIdList(id);

        return new ResponseEntity<List<SuppliesDevice>>(SuppliesDevices, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SuppliesDevice> createSuppliesDevice(@RequestBody final SuppliesDevice SuppliesDevice) {

        SuppliesDeviceJpaRepository.save(SuppliesDevice);
        return new ResponseEntity<SuppliesDevice>(SuppliesDevice, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{idDevice}/{idListWorkOrder}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SuppliesDevice> updateSuppliesDevice(@PathVariable("idDevice") final int deviceId, @PathVariable("idListWorkOrder") final int listWorkOrderId, @RequestBody final SuppliesDevice SuppliesDevice){

        SuppliesDeviceId id = new SuppliesDeviceId( );
        id.getDevice().setId(deviceId);
        id.getListWorkOrder().setId(listWorkOrderId);

        SuppliesDevice currentSuppliesDevice =  SuppliesDeviceJpaRepository.findById(id).get();

        currentSuppliesDevice.setQuantity(SuppliesDevice.getQuantity());

        SuppliesDeviceJpaRepository.saveAndFlush(currentSuppliesDevice);

        return new ResponseEntity<SuppliesDevice>(currentSuppliesDevice,HttpStatus.OK);
    }

    @DeleteMapping("/{idDevice}/{idListWorkOrder}")
    public ResponseEntity<SuppliesDevice> deleteSuppliesDevice(@PathVariable("idDevice") final int deviceId, @PathVariable("idListWorkOrder") final int listWorkOrderId) {

        SuppliesDeviceId id = new SuppliesDeviceId( );
        id.getDevice().setId(deviceId);
        id.getListWorkOrder().setId(listWorkOrderId);

        SuppliesDeviceJpaRepository.deleteById(id);

        return new ResponseEntity<SuppliesDevice>(HttpStatus.NO_CONTENT);
    }
}
