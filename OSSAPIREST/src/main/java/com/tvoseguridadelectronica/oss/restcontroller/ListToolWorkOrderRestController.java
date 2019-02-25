package com.tvoseguridadelectronica.oss.restcontroller;

import com.tvoseguridadelectronica.oss.domain.ListToolWorkOrder;
import com.tvoseguridadelectronica.oss.domain.ListToolWorkOrderId;
import com.tvoseguridadelectronica.oss.domain.ListToolWorkOrder;
import com.tvoseguridadelectronica.oss.domain.ListToolWorkOrderId;
import com.tvoseguridadelectronica.oss.jparepository.ListToolWorkOrderJpaRepository;
import com.tvoseguridadelectronica.oss.jparepository.ListToolWorkOrderJpaRepository;
import com.tvoseguridadelectronica.oss.repository.ListToolWorkOrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping({"api/listtoolworkorder"})
public class ListToolWorkOrderRestController {
    
    private ListToolWorkOrderJpaRepository listToolWorkOrderJpaRepository;
    private ListToolWorkOrderDao listToolWorkOrderDao;

    @Autowired
    public void setListTool(ListToolWorkOrderJpaRepository listToolWorkOrderJpaRepository, ListToolWorkOrderDao listToolWorkOrderDao) {
        this.listToolWorkOrderJpaRepository = listToolWorkOrderJpaRepository;
        this.listToolWorkOrderDao = listToolWorkOrderDao;
    }

    @GetMapping("/")
    public ResponseEntity<List<ListToolWorkOrder>> listAllListToolWorkOrders() {

        List <ListToolWorkOrder> ListToolWorkOrders = listToolWorkOrderJpaRepository.findAll();
        return  new ResponseEntity<List<ListToolWorkOrder>>(ListToolWorkOrders, HttpStatus.OK);
    }

    @GetMapping("/{idTool}/{idListWorkOrder}")
    public ResponseEntity<ListToolWorkOrder> getListToolWorkOrderById(@PathVariable("idTool") final int toolId, @PathVariable("idListWorkOrder") final int listWorkOrderId) {

        ListToolWorkOrderId id = new ListToolWorkOrderId( );
        id.getTool().setId(toolId);
        id.getListWorkOrder().setId(listWorkOrderId);

        ListToolWorkOrder ListToolWorkOrder = listToolWorkOrderJpaRepository.findById(id).get();
        return new ResponseEntity<ListToolWorkOrder>(ListToolWorkOrder, HttpStatus.OK);
    }

    @GetMapping("/findByIdList/{id}")
    public ResponseEntity<List<ListToolWorkOrder>> getListToolByIdListWorkOrder(@PathVariable("id") final int id) throws SQLException {

        List<ListToolWorkOrder> listToolWorkOrders = listToolWorkOrderDao.findByIdList(id);

        return new ResponseEntity<List<ListToolWorkOrder>>(listToolWorkOrders, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListToolWorkOrder> createListToolWorkOrder(@RequestBody final ListToolWorkOrder listToolWorkOrder) {

        listToolWorkOrderJpaRepository.save(listToolWorkOrder);
        return new ResponseEntity<ListToolWorkOrder>(listToolWorkOrder, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{idTool}/{idListWorkOrder}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListToolWorkOrder> updateListToolWorkOrder(@PathVariable("idTool") final int toolId, @PathVariable("idListWorkOrder") final int listWorkOrderId, @RequestBody final ListToolWorkOrder listToolWorkOrder){

        ListToolWorkOrderId id = new ListToolWorkOrderId( );
        id.getTool().setId(toolId);
        id.getListWorkOrder().setId(listWorkOrderId);

        ListToolWorkOrder currentListToolWorkOrder =  listToolWorkOrderJpaRepository.findById(id).get();

        currentListToolWorkOrder.setQuantity(listToolWorkOrder.getQuantity());

        listToolWorkOrderJpaRepository.saveAndFlush(currentListToolWorkOrder);

        return new ResponseEntity<ListToolWorkOrder>(currentListToolWorkOrder,HttpStatus.OK);
    }

    @DeleteMapping("/{idTool}/{idListWorkOrder}")
    public ResponseEntity<ListToolWorkOrder> deleteListToolWorkOrder(@PathVariable("idTool") final int toolId, @PathVariable("idListWorkOrder") final int listWorkOrderId) {

        ListToolWorkOrderId id = new ListToolWorkOrderId( );
        id.getTool().setId(toolId);
        id.getListWorkOrder().setId(listWorkOrderId);

        listToolWorkOrderJpaRepository.deleteById(id);

        return new ResponseEntity<ListToolWorkOrder>(HttpStatus.NO_CONTENT);
    }
}
