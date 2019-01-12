package com.tvoseguridadelectronica.oss.restcontroller;

import com.tvoseguridadelectronica.oss.domain.ListWorkOrder;
import com.tvoseguridadelectronica.oss.jparepository.ListWorkOrderJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"api/listworkorder"})
public class ListWorkOrderRestController {

    @Autowired
    private ListWorkOrderJpaRepository listWorkOrderJpaRepository;

    @GetMapping("/")
    public ResponseEntity<List<ListWorkOrder>> listAllListWorkOrder() {

        List <ListWorkOrder> listWorkOrders = listWorkOrderJpaRepository.findAll();
        return  new ResponseEntity<List<ListWorkOrder>>(listWorkOrders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListWorkOrder> getListWorkOrderById(@PathVariable("id") final Integer id) {

        ListWorkOrder ListWorkOrder = listWorkOrderJpaRepository.findById(id).get();
        return new ResponseEntity<ListWorkOrder>(ListWorkOrder, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListWorkOrder> createListWorkOrder(@RequestBody final ListWorkOrder listWorkOrder) {

        listWorkOrderJpaRepository.save(listWorkOrder);
        return new ResponseEntity<ListWorkOrder>(listWorkOrder, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListWorkOrder> updateListWorkOrder(@PathVariable("id") final Integer id, @RequestBody final ListWorkOrder listWorkOrder){

        ListWorkOrder currentListWorkOrder = listWorkOrderJpaRepository.findById(id).get();

        currentListWorkOrder.setName(listWorkOrder.getName());

        listWorkOrderJpaRepository.saveAndFlush(currentListWorkOrder);

        return new ResponseEntity<ListWorkOrder>(currentListWorkOrder,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ListWorkOrder> deleteListWorkOrder(@PathVariable("id") final Integer id) {

        listWorkOrderJpaRepository.deleteById(id);

        return new ResponseEntity<ListWorkOrder>(HttpStatus.NO_CONTENT);
    }
}
