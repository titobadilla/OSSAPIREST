package com.tvoseguridadelectronica.oss.restcontroller;

import com.tvoseguridadelectronica.oss.domain.SuppliesTool;
import com.tvoseguridadelectronica.oss.domain.SuppliesToolId;
import com.tvoseguridadelectronica.oss.jparepository.SuppliesToolsJpaRepository;
import com.tvoseguridadelectronica.oss.repository.SuppliesToolDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping({"api/suppliestool"})
public class SuppliesToolRestController {
    
    private SuppliesToolsJpaRepository suppliesToolsJpaRepository;
    private SuppliesToolDao suppliesToolDao;

    @Autowired
    public void setListTool(SuppliesToolsJpaRepository suppliesToolsJpaRepository, SuppliesToolDao suppliesToolDao) {
        this.suppliesToolsJpaRepository = suppliesToolsJpaRepository;
        this.suppliesToolDao = suppliesToolDao;
    }

    @GetMapping("/")
    public ResponseEntity<List<SuppliesTool>> listAllListToolWorkOrders() {

        List <SuppliesTool> suppliesTools = this.suppliesToolsJpaRepository.findAll();
        return  new ResponseEntity<List<SuppliesTool>>(suppliesTools, HttpStatus.OK);
    }

    @GetMapping("/{idTool}/{idListWorkOrder}")
    public ResponseEntity<SuppliesTool> getListToolWorkOrderById(@PathVariable("idTool") final int toolId, @PathVariable("idListWorkOrder") final int listWorkOrderId) {

        SuppliesToolId id = new SuppliesToolId( );
        id.getTool().setId(toolId);
        id.getkitWorkOrder().setId(listWorkOrderId);

        SuppliesTool SuppliesTools = suppliesToolsJpaRepository.findById(id).get();
        return new ResponseEntity<SuppliesTool>(SuppliesTools, HttpStatus.OK);
    }

    @GetMapping("/findByIdList/{id}")
    public ResponseEntity<List<SuppliesTool>> getListToolByIdListWorkOrder(@PathVariable("id") final int id) throws SQLException {

        List<SuppliesTool> suppliesTools = suppliesToolDao.findByIdList(id);

        return new ResponseEntity<List<SuppliesTool>>(suppliesTools, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SuppliesTool> createListToolWorkOrder(@RequestBody final SuppliesTool suppliesTools) {

        this.suppliesToolsJpaRepository.save(suppliesTools);
        return new ResponseEntity<SuppliesTool>(suppliesTools, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{idTool}/{idListWorkOrder}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SuppliesTool> updateListToolWorkOrder(@PathVariable("idTool") final int toolId, @PathVariable("idListWorkOrder") final int listWorkOrderId, @RequestBody final SuppliesTool suppliesTools){

        SuppliesToolId id = new SuppliesToolId( );
        id.getTool().setId(toolId);
        id.getkitWorkOrder().setId(listWorkOrderId);

        SuppliesTool currentSuppliesTools =  this.suppliesToolsJpaRepository.findById(id).get();

        currentSuppliesTools.setQuantity(suppliesTools.getQuantity());

        this.suppliesToolsJpaRepository.saveAndFlush(currentSuppliesTools);

        return new ResponseEntity<SuppliesTool>(currentSuppliesTools,HttpStatus.OK);
    }

    @DeleteMapping("/{idTool}/{idListWorkOrder}")
    public ResponseEntity<SuppliesTool> deleteListToolWorkOrder(@PathVariable("idTool") final int toolId, @PathVariable("idListWorkOrder") final int listWorkOrderId) {

        SuppliesToolId id = new SuppliesToolId( );
        id.getTool().setId(toolId);
        id.getkitWorkOrder().setId(listWorkOrderId);

        suppliesToolsJpaRepository.deleteById(id);

        return new ResponseEntity<SuppliesTool>(HttpStatus.NO_CONTENT);
    }
}
