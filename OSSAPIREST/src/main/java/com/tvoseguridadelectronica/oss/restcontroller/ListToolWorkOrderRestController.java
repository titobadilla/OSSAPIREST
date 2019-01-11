package com.tvoseguridadelectronica.oss.restcontroller;

import com.tvoseguridadelectronica.oss.domain.ListToolWorkOrder;
import com.tvoseguridadelectronica.oss.domain.ListToolWorkOrderId;
import com.tvoseguridadelectronica.oss.jparepository.ListToolWorkOrderJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"api/listToolWorkOrder"})
public class ListToolWorkOrderRestController {

    @Autowired
    private ListToolWorkOrderJpaRepository listToolWorkOrderJpaRepository;


    @GetMapping("/")
    public ResponseEntity<List<ListToolWorkOrder>> listAllListToolWorkOrders() {

        List <ListToolWorkOrder> ListToolWorkOrders = listToolWorkOrderJpaRepository.findAll();
        return  new ResponseEntity<List<ListToolWorkOrder>>(ListToolWorkOrders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListToolWorkOrder> getListToolWorkOrderById(@PathVariable("id") final ListToolWorkOrderId id) {

        ListToolWorkOrder ListToolWorkOrder = listToolWorkOrderJpaRepository.findById(id).get();
        return new ResponseEntity<ListToolWorkOrder>(ListToolWorkOrder, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListToolWorkOrder> createListToolWorkOrder(@RequestBody final ListToolWorkOrder listToolWorkOrder) {

        listToolWorkOrderJpaRepository.save(listToolWorkOrder);
        return new ResponseEntity<ListToolWorkOrder>(listToolWorkOrder, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListToolWorkOrder> updateListToolWorkOrder(@PathVariable("id") final ListToolWorkOrderId id, @RequestBody final ListToolWorkOrder listToolWorkOrder){

        ListToolWorkOrder currentListToolWorkOrder =  listToolWorkOrderJpaRepository.findById(id).get();

        currentListToolWorkOrder.setQuantity(listToolWorkOrder.getQuantity());

        listToolWorkOrderJpaRepository.saveAndFlush(currentListToolWorkOrder);

        return new ResponseEntity<ListToolWorkOrder>(currentListToolWorkOrder,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ListToolWorkOrder> deleteListToolWorkOrder(@PathVariable("id") final ListToolWorkOrderId id) {

        listToolWorkOrderJpaRepository.deleteById(id);

        return new ResponseEntity<ListToolWorkOrder>(HttpStatus.NO_CONTENT);
    }
}
