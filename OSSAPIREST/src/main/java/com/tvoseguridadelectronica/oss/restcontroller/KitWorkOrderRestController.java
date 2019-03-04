package com.tvoseguridadelectronica.oss.restcontroller;

import com.tvoseguridadelectronica.oss.domain.KitWorkOrder;
import com.tvoseguridadelectronica.oss.jparepository.KitWorkOrderJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping({"api/listworkorder"})
public class KitWorkOrderRestController {

    @Autowired
    private KitWorkOrderJpaRepository kitWorkOrderJpaRepository;

    @GetMapping("/")
    public ResponseEntity<List<KitWorkOrder>> listAllListWorkOrder() {

        List <KitWorkOrder> kitWorkOrders = kitWorkOrderJpaRepository.findAll();
        return  new ResponseEntity<List<KitWorkOrder>>(kitWorkOrders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<KitWorkOrder> getListWorkOrderById(@PathVariable("id") final Integer id) {

        KitWorkOrder KitWorkOrder = kitWorkOrderJpaRepository.findById(id).get();
        return new ResponseEntity<KitWorkOrder>(KitWorkOrder, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KitWorkOrder> createListWorkOrder(@RequestBody final KitWorkOrder kitWorkOrder) {

        kitWorkOrderJpaRepository.save(kitWorkOrder);
        return new ResponseEntity<KitWorkOrder>(kitWorkOrder, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KitWorkOrder> updateListWorkOrder(@PathVariable("id") final Integer id, @RequestBody final KitWorkOrder kitWorkOrder){

        KitWorkOrder currentKitWorkOrder = kitWorkOrderJpaRepository.findById(id).get();

        currentKitWorkOrder.setName(kitWorkOrder.getName());

        kitWorkOrderJpaRepository.saveAndFlush(currentKitWorkOrder);

        return new ResponseEntity<KitWorkOrder>(currentKitWorkOrder,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<KitWorkOrder> deleteListWorkOrder(@PathVariable("id") final Integer id) {

        kitWorkOrderJpaRepository.deleteById(id);

        return new ResponseEntity<KitWorkOrder>(HttpStatus.NO_CONTENT);
    }
}
