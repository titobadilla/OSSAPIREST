package com.tvoseguridadelectronica.oss.restcontroller;

import com.tvoseguridadelectronica.oss.domain.DeviceState;
import com.tvoseguridadelectronica.oss.jparepository.DeviceStateJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping({"/api/devicestate"})
public class DeviceStateRestController {

    @Autowired
    private DeviceStateJpaRepository deviceStateJpaRepository;

    @GetMapping("/")
    public ResponseEntity<List<DeviceState>> listAllDeviceState() {
        List<DeviceState> deviceStates = deviceStateJpaRepository.findAll();
        return new ResponseEntity<List<DeviceState>>(deviceStates, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeviceState> createDevice(@RequestBody final DeviceState deviceState) {
        deviceStateJpaRepository.save(deviceState);
        return new ResponseEntity<DeviceState>(deviceState, HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeviceState> editDevice(@RequestBody final DeviceState deviceState) {
        deviceStateJpaRepository.saveAndFlush(deviceState);
        return new ResponseEntity<DeviceState>(deviceState, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceState> findDeviceById(@PathVariable("id") final int id ) {
        DeviceState deviceState = deviceStateJpaRepository.findById(id).get();
        return new ResponseEntity<DeviceState>(deviceState, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeviceState> deleteDevice(@PathVariable("id") final int id) {
        deviceStateJpaRepository.deleteById(id);
        return new ResponseEntity<DeviceState>(HttpStatus.NO_CONTENT);
    }
}
