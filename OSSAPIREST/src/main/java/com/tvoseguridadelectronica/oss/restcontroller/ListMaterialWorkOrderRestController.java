package com.tvoseguridadelectronica.oss.restcontroller;

import com.tvoseguridadelectronica.oss.domain.ListMaterialWorkOrder;
import com.tvoseguridadelectronica.oss.domain.ListMaterialWorkOrderId;
import com.tvoseguridadelectronica.oss.jparepository.ListMaterialWorkOrderJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"api/listMaterialWorkOrder"})
public class ListMaterialWorkOrderRestController {


    @Autowired
    private ListMaterialWorkOrderJpaRepository listMaterialWorkOrderJpaRepository;


    @GetMapping("/")
    public ResponseEntity<List<ListMaterialWorkOrder>> listAllListMaterialWorkOrders() {

        List <ListMaterialWorkOrder> listMaterialWorkOrders = listMaterialWorkOrderJpaRepository.findAll();
        return  new ResponseEntity<List<ListMaterialWorkOrder>>(listMaterialWorkOrders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListMaterialWorkOrder> getListMaterialWorkOrderById(@PathVariable("id") final ListMaterialWorkOrderId id) {

        ListMaterialWorkOrder ListMaterialWorkOrder = listMaterialWorkOrderJpaRepository.findById(id).get();
        return new ResponseEntity<ListMaterialWorkOrder>(ListMaterialWorkOrder, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListMaterialWorkOrder> createlistMaterialWorkOrder(@RequestBody final ListMaterialWorkOrder listMaterialWorkOrder) {

        listMaterialWorkOrderJpaRepository.save(listMaterialWorkOrder);
        return new ResponseEntity<ListMaterialWorkOrder>(listMaterialWorkOrder, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListMaterialWorkOrder> updateListMaterialWorkOrder(@PathVariable("id") final ListMaterialWorkOrderId id, @RequestBody final ListMaterialWorkOrder listMaterialWorkOrder){

        ListMaterialWorkOrder currentListMaterialWorkOrder =  listMaterialWorkOrderJpaRepository.findById(id).get();

        currentListMaterialWorkOrder.setQuantity(listMaterialWorkOrder.getQuantity());

        listMaterialWorkOrderJpaRepository.saveAndFlush(currentListMaterialWorkOrder);

        return new ResponseEntity<ListMaterialWorkOrder>(currentListMaterialWorkOrder,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ListMaterialWorkOrder> deleteListMaterialWorkOrder(@PathVariable("id") final ListMaterialWorkOrderId id) {

        listMaterialWorkOrderJpaRepository.deleteById(id);

        return new ResponseEntity<ListMaterialWorkOrder>(HttpStatus.NO_CONTENT);
    }
    
}
