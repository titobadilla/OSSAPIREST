package com.tvoseguridadelectronica.oss.restcontroller;

import com.tvoseguridadelectronica.oss.domain.InventoryCategory;
import com.tvoseguridadelectronica.oss.domain.ListDeviceWorkOrder;
import com.tvoseguridadelectronica.oss.domain.ListDeviceWorkOrderId;
import com.tvoseguridadelectronica.oss.jparepository.ListDeviceWorkOrderJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"api/listDeviceWorkOrder"})
public class ListDeviceWorkOrderRestController {

    @Autowired
    private ListDeviceWorkOrderJpaRepository listDeviceWorkOrderJpaRepository;


    @GetMapping("/")
    public ResponseEntity<List<ListDeviceWorkOrder>> listAllListDeviceWorkOrders() {

        List <ListDeviceWorkOrder> listDeviceWorkOrders = listDeviceWorkOrderJpaRepository.findAll();
        return  new ResponseEntity<List<ListDeviceWorkOrder>>(listDeviceWorkOrders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListDeviceWorkOrder> getListDeviceWorkOrderById(@PathVariable("id") final ListDeviceWorkOrderId id) {

        ListDeviceWorkOrder listDeviceWorkOrder = listDeviceWorkOrderJpaRepository.findById(id).get();
        return new ResponseEntity<ListDeviceWorkOrder>(listDeviceWorkOrder, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListDeviceWorkOrder> createlistDeviceWorkOrder(@RequestBody final ListDeviceWorkOrder listDeviceWorkOrder) {

        listDeviceWorkOrderJpaRepository.save(listDeviceWorkOrder);
        return new ResponseEntity<ListDeviceWorkOrder>(listDeviceWorkOrder, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListDeviceWorkOrder> updateListDeviceWorkOrder(@PathVariable("id") final ListDeviceWorkOrderId id, @RequestBody final ListDeviceWorkOrder listDeviceWorkOrder){

        ListDeviceWorkOrder currentListDeviceWorkOrder =  listDeviceWorkOrderJpaRepository.findById(id).get();

        currentListDeviceWorkOrder.setQuantity(listDeviceWorkOrder.getQuantity());

        listDeviceWorkOrderJpaRepository.saveAndFlush(currentListDeviceWorkOrder);

        return new ResponseEntity<ListDeviceWorkOrder>(currentListDeviceWorkOrder,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ListDeviceWorkOrder> deleteListDeviceWorkOrder(@PathVariable("id") final ListDeviceWorkOrderId id) {

        listDeviceWorkOrderJpaRepository.deleteById(id);

        return new ResponseEntity<ListDeviceWorkOrder>(HttpStatus.NO_CONTENT);
    }
}
