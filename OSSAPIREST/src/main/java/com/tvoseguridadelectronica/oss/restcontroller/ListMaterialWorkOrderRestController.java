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

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping({"api/listmaterialworkorder"})
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

        System.out.println(listMaterialWorkOrder.getQuantity()+"   "+listMaterialWorkOrder.getId().getMaterialId()+"  "+listMaterialWorkOrder.getId().getListWorkOrderId());

        listMaterialWorkOrderJpaRepository.save(listMaterialWorkOrder);
        return new ResponseEntity<ListMaterialWorkOrder>(listMaterialWorkOrder, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{idMaterial}/{idListWorkOrder}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListMaterialWorkOrder> updateListMaterialWorkOrder(@PathVariable("idMaterial") final int materialId, @PathVariable("idListWorkOrder") final int listWorkOrderId, @RequestBody final ListMaterialWorkOrder listMaterialWorkOrder){

        ListMaterialWorkOrderId id = new ListMaterialWorkOrderId( );
        id.setMaterialId(materialId);
        id.setListWorkOrderId(listWorkOrderId);

        ListMaterialWorkOrder currentListMaterialWorkOrder =  listMaterialWorkOrderJpaRepository.findById(id).get();

        currentListMaterialWorkOrder.setQuantity(listMaterialWorkOrder.getQuantity());

        listMaterialWorkOrderJpaRepository.saveAndFlush(currentListMaterialWorkOrder);

        return new ResponseEntity<ListMaterialWorkOrder>(currentListMaterialWorkOrder,HttpStatus.OK);
    }

    @DeleteMapping("/{idMaterial}/{idListWorkOrder}")
    public ResponseEntity<ListMaterialWorkOrder> deleteListMaterialWorkOrder(@PathVariable("idMaterial") final int materialId, @PathVariable("idListWorkOrder") final int listWorkOrderId) {

        ListMaterialWorkOrderId id = new ListMaterialWorkOrderId( );
        id.setMaterialId(materialId);
        id.setListWorkOrderId(listWorkOrderId);

        listMaterialWorkOrderJpaRepository.deleteById(id);

        return new ResponseEntity<ListMaterialWorkOrder>(HttpStatus.NO_CONTENT);
    }
    
}
