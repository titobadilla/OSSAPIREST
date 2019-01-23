package com.tvoseguridadelectronica.oss.restcontroller;

import com.tvoseguridadelectronica.oss.domain.*;
import com.tvoseguridadelectronica.oss.jparepository.ListDeviceWorkOrderJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping({"api/listdeviceworkorder"})
public class ListDeviceWorkOrderRestController {

    @Autowired
    private ListDeviceWorkOrderJpaRepository listDeviceWorkOrderJpaRepository;


    @GetMapping("/")
    public ResponseEntity<List<ListDeviceWorkOrder>> listAllListDeviceWorkOrders() {

        List <ListDeviceWorkOrder> listDeviceWorkOrders = listDeviceWorkOrderJpaRepository.findAll();
        return  new ResponseEntity<List<ListDeviceWorkOrder>>(listDeviceWorkOrders, HttpStatus.OK);
    }

    @GetMapping("/{idDevice}/{idListWorkOrder}")
    public ResponseEntity<ListDeviceWorkOrder> getListDeviceWorkOrderById(@PathVariable("idDevice") final int deviceId, @PathVariable("idListWorkOrder") final int listWorkOrderId) {

        ListDeviceWorkOrderId id = new ListDeviceWorkOrderId( );
        id.setDeviceId(deviceId);
        id.setListWorkOrderId(listWorkOrderId);

        ListDeviceWorkOrder listDeviceWorkOrder = listDeviceWorkOrderJpaRepository.findById(id).get();
        return new ResponseEntity<ListDeviceWorkOrder>(listDeviceWorkOrder, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListDeviceWorkOrder> createlistDeviceWorkOrder(@RequestBody final ListDeviceWorkOrder listDeviceWorkOrder) {

        System.out.println(listDeviceWorkOrder.getQuantity()+"   "+listDeviceWorkOrder.getId().getDeviceId()+"  "+listDeviceWorkOrder.getId().getListWorkOrderId());
        listDeviceWorkOrderJpaRepository.save(listDeviceWorkOrder);
        return new ResponseEntity<ListDeviceWorkOrder>(listDeviceWorkOrder, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{idDevice}/{idListWorkOrder}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListDeviceWorkOrder> updateListDeviceWorkOrder(@PathVariable("idDevice") final int deviceId, @PathVariable("idListWorkOrder") final int listWorkOrderId, @RequestBody final ListDeviceWorkOrder listDeviceWorkOrder){

        ListDeviceWorkOrderId id = new ListDeviceWorkOrderId( );
        id.setDeviceId(deviceId);
        id.setListWorkOrderId(listWorkOrderId);

        ListDeviceWorkOrder currentListDeviceWorkOrder =  listDeviceWorkOrderJpaRepository.findById(id).get();

        currentListDeviceWorkOrder.setQuantity(listDeviceWorkOrder.getQuantity());

        listDeviceWorkOrderJpaRepository.saveAndFlush(currentListDeviceWorkOrder);

        return new ResponseEntity<ListDeviceWorkOrder>(currentListDeviceWorkOrder,HttpStatus.OK);
    }

    @DeleteMapping("/{idDevice}/{idListWorkOrder}")
    public ResponseEntity<ListDeviceWorkOrder> deleteListDeviceWorkOrder(@PathVariable("idDevice") final int deviceId, @PathVariable("idListWorkOrder") final int listWorkOrderId) {

        ListDeviceWorkOrderId id = new ListDeviceWorkOrderId( );
        id.setDeviceId(deviceId);
        id.setListWorkOrderId(listWorkOrderId);

        listDeviceWorkOrderJpaRepository.deleteById(id);

        return new ResponseEntity<ListDeviceWorkOrder>(HttpStatus.NO_CONTENT);
    }
}
