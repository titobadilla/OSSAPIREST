package com.tvoseguridadelectronica.oss.restcontroller;

import com.tvoseguridadelectronica.oss.domain.SuppliesTools;
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
    public ResponseEntity<List<SuppliesTools>> listAllListToolWorkOrders() {

        List <SuppliesTools> suppliesTools = this.suppliesToolsJpaRepository.findAll();
        return  new ResponseEntity<List<SuppliesTools>>(suppliesTools, HttpStatus.OK);
    }

    @GetMapping("/{idTool}/{idListWorkOrder}")
    public ResponseEntity<SuppliesTools> getListToolWorkOrderById(@PathVariable("idTool") final int toolId, @PathVariable("idListWorkOrder") final int listWorkOrderId) {

        SuppliesToolId id = new SuppliesToolId( );
        id.getTool().setId(toolId);
        id.getListWorkOrder().setId(listWorkOrderId);

        SuppliesTools SuppliesTools = suppliesToolsJpaRepository.findById(id).get();
        return new ResponseEntity<SuppliesTools>(SuppliesTools, HttpStatus.OK);
    }

    @GetMapping("/findByIdList/{id}")
    public ResponseEntity<List<SuppliesTools>> getListToolByIdListWorkOrder(@PathVariable("id") final int id) throws SQLException {

        List<SuppliesTools> suppliesTools = suppliesToolDao.findByIdList(id);

        return new ResponseEntity<List<SuppliesTools>>(suppliesTools, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SuppliesTools> createListToolWorkOrder(@RequestBody final SuppliesTools suppliesTools) {

        this.suppliesToolsJpaRepository.save(suppliesTools);
        return new ResponseEntity<SuppliesTools>(suppliesTools, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{idTool}/{idListWorkOrder}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SuppliesTools> updateListToolWorkOrder(@PathVariable("idTool") final int toolId, @PathVariable("idListWorkOrder") final int listWorkOrderId, @RequestBody final SuppliesTools suppliesTools){

        SuppliesToolId id = new SuppliesToolId( );
        id.getTool().setId(toolId);
        id.getListWorkOrder().setId(listWorkOrderId);

        SuppliesTools currentSuppliesTools =  this.suppliesToolsJpaRepository.findById(id).get();

        currentSuppliesTools.setQuantity(suppliesTools.getQuantity());

        this.suppliesToolsJpaRepository.saveAndFlush(currentSuppliesTools);

        return new ResponseEntity<SuppliesTools>(currentSuppliesTools,HttpStatus.OK);
    }

    @DeleteMapping("/{idTool}/{idListWorkOrder}")
    public ResponseEntity<SuppliesTools> deleteListToolWorkOrder(@PathVariable("idTool") final int toolId, @PathVariable("idListWorkOrder") final int listWorkOrderId) {

        SuppliesToolId id = new SuppliesToolId( );
        id.getTool().setId(toolId);
        id.getListWorkOrder().setId(listWorkOrderId);

        suppliesToolsJpaRepository.deleteById(id);

        return new ResponseEntity<SuppliesTools>(HttpStatus.NO_CONTENT);
    }
}
