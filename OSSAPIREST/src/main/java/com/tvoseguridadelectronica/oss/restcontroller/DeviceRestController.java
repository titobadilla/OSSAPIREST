package com.tvoseguridadelectronica.oss.restcontroller;

import com.tvoseguridadelectronica.oss.domain.Device;
import com.tvoseguridadelectronica.oss.domain.Device;
import com.tvoseguridadelectronica.oss.jparepository.DeviceJpaRepository;
import com.tvoseguridadelectronica.oss.repository.DeviceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping({"/api/device"})
public class DeviceRestController {

    @Autowired
    private DeviceJpaRepository deviceJpaRepository;

    @Autowired
    private DeviceDao deviceDao;

    @GetMapping("/")
    public ResponseEntity<List<Device>> listAllDevice() {
        List<Device> devices = deviceJpaRepository.findAll();
        return new ResponseEntity<List<Device>>(devices, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Device> createDevice(@RequestBody final Device device) {
        deviceJpaRepository.save(device);
        return new ResponseEntity<Device>(device, HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Device> editDevice(@PathVariable("id") final Integer id,@RequestBody final Device device) {

      Device device2 = deviceJpaRepository.findById(id).get();

      device2.setSerialNumber(device.getSerialNumber());
      device2.setName(device.getName());
      device2.setDescription(device.getDescription());
      device2.setManufactureModel(device.getManufactureModel());
      device2.setModel(device.getModel());
      device2.setInventoryCategory(device.getInventoryCategory());
      device2.setMeasurementUnit(device.getMeasurementUnit());
      device2.setDeviceState(device.getDeviceState());

        deviceJpaRepository.saveAndFlush(device2);
        return new ResponseEntity<Device>(device2, HttpStatus.OK);
    }

    @PutMapping(value = "updateQuantity/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Device> editDeviceQuantity(@PathVariable("id") final Integer id,@RequestBody final Device device) {
        Device device2= null;
        try {
            device2 = deviceJpaRepository.findById(id).get();

            device2.setQuantity(device.getQuantity());

            deviceDao.updateDevice(device2);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Device>(device2, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> findDeviceById(@PathVariable("id") final int id ) {
        Device device = deviceJpaRepository.findById(id).get();
        return new ResponseEntity<Device>(device, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Device> deleteDevice(@PathVariable("id") final int id) {
        deviceJpaRepository.deleteById(id);
        return new ResponseEntity<Device>(HttpStatus.NO_CONTENT);
    }
}
