package com.tvoseguridadelectronica.oss.restcontroller;

import com.tvoseguridadelectronica.oss.domain.MeasurementUnit;
import com.tvoseguridadelectronica.oss.domain.MeasurementUnit;
import com.tvoseguridadelectronica.oss.jparepository.MeasurementUnitJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping({"/api/measurementunit"})
public class MeasurementUnitRestController {

    @Autowired
    private MeasurementUnitJpaRepository measurementUnitJpaRepository;

    @GetMapping("/")
    public ResponseEntity<List<MeasurementUnit>> listAllMeasurementUnit() {
        List<MeasurementUnit> measurementUnits = measurementUnitJpaRepository.findAll();
        return new ResponseEntity<List<MeasurementUnit>>(measurementUnits, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MeasurementUnit> createMeasurementUnit(@RequestBody final MeasurementUnit measurementUnit) {
        measurementUnitJpaRepository.save(measurementUnit);
        return new ResponseEntity<MeasurementUnit>(measurementUnit, HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MeasurementUnit> editMeasurementUnit(@PathVariable("id") final Integer id,@RequestBody final MeasurementUnit measurementUnit) {

        MeasurementUnit measurementUnit2 = measurementUnitJpaRepository.findById(id).get();

        measurementUnit2.setName(measurementUnit.getName());

        measurementUnitJpaRepository.saveAndFlush(measurementUnit2);
        return new ResponseEntity<MeasurementUnit>(measurementUnit2, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MeasurementUnit> findMeasurementUnitById(@PathVariable("id") final int id ) {

        MeasurementUnit measurementUnit = measurementUnitJpaRepository.findById(id).get();
        return new ResponseEntity<MeasurementUnit>(measurementUnit, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MeasurementUnit> deleteMeasurementUnit(@PathVariable("id") final int id) {
        measurementUnitJpaRepository.deleteById(id);
        return new ResponseEntity<MeasurementUnit>(HttpStatus.NO_CONTENT);
    }
}
