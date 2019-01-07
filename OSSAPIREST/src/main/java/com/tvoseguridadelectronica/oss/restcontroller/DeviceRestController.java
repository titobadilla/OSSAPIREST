package com.tvoseguridadelectronica.oss.restcontroller;

import com.tvoseguridadelectronica.oss.domain.Device;
import com.tvoseguridadelectronica.oss.domain.Device;
import com.tvoseguridadelectronica.oss.jparepository.DeviceJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/device"})
public class DeviceRestController {

    @Autowired
    private DeviceJpaRepository deviceJpaRepository;

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

    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Device> editDevice(@RequestBody final Device device) {
        deviceJpaRepository.saveAndFlush(device);
        return new ResponseEntity<Device>(device, HttpStatus.OK);
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
