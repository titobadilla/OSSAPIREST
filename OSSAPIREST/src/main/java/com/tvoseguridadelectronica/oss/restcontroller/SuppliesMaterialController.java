package com.tvoseguridadelectronica.oss.restcontroller;

import com.tvoseguridadelectronica.oss.domain.SuppliesMaterial;
import com.tvoseguridadelectronica.oss.domain.SuppliesMaterialId;
import com.tvoseguridadelectronica.oss.jparepository.SuppliesMaterialJpaRepository;
import com.tvoseguridadelectronica.oss.repository.SuppliesMaterialDao;
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
@RequestMapping({"api/suppliesmaterial"})
public class SuppliesMaterialController {

    private SuppliesMaterialJpaRepository suppliesMaterialJpaRepository;
    private SuppliesMaterialDao suppliesMaterialDao;

    @Autowired
    public void setListMaterial(SuppliesMaterialJpaRepository suppliesMaterialJpaRepository, SuppliesMaterialDao suppliesMaterialDao) {
        this.suppliesMaterialJpaRepository = suppliesMaterialJpaRepository;
        this.suppliesMaterialDao = suppliesMaterialDao;

    }

    @GetMapping("/")
    public ResponseEntity<List<SuppliesMaterial>> listAllListMaterialWorkOrders() {

        List <SuppliesMaterial> suppliesMaterials = suppliesMaterialJpaRepository.findAll();
        return  new ResponseEntity<List<SuppliesMaterial>>(suppliesMaterials, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuppliesMaterial> getListMaterialWorkOrderById(@PathVariable("id") final SuppliesMaterialId id) {

        SuppliesMaterial SuppliesMaterial = suppliesMaterialJpaRepository.findById(id).get();
        return new ResponseEntity<SuppliesMaterial>(SuppliesMaterial, HttpStatus.OK);
    }

    @GetMapping("/findByIdList/{id}")
    public ResponseEntity<List<SuppliesMaterial>> getListMaterialByIdListWorkOrder(@PathVariable("id") final int id) throws SQLException {

        System.out.print(id);
        System.out.println("entro");

        List<SuppliesMaterial> suppliesMaterials = suppliesMaterialDao.findByIdList(id);

        return new ResponseEntity<List<SuppliesMaterial>>(suppliesMaterials, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SuppliesMaterial> createlistMaterialWorkOrder(@RequestBody final SuppliesMaterial suppliesMaterial) {

        suppliesMaterialJpaRepository.save(suppliesMaterial);
        return new ResponseEntity<SuppliesMaterial>(suppliesMaterial, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{idMaterial}/{idListWorkOrder}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SuppliesMaterial> updateListMaterialWorkOrder(@PathVariable("idMaterial") final int materialId, @PathVariable("idListWorkOrder") final int listWorkOrderId, @RequestBody final SuppliesMaterial suppliesMaterial){

        SuppliesMaterialId id = new SuppliesMaterialId( );
        id.getMaterial().setId(materialId);
        id.getkitWorkOrder().setId(listWorkOrderId);

        SuppliesMaterial currentSuppliesMaterial =  suppliesMaterialJpaRepository.findById(id).get();

        currentSuppliesMaterial.setQuantity(suppliesMaterial.getQuantity());

        suppliesMaterialJpaRepository.saveAndFlush(currentSuppliesMaterial);

        return new ResponseEntity<SuppliesMaterial>(currentSuppliesMaterial,HttpStatus.OK);
    }

    @DeleteMapping("/{idMaterial}/{idListWorkOrder}")
    public ResponseEntity<SuppliesMaterial> deleteListMaterialWorkOrder(@PathVariable("idMaterial") final int materialId, @PathVariable("idListWorkOrder") final int listWorkOrderId) {

        SuppliesMaterialId id = new SuppliesMaterialId( );
        id.getMaterial().setId(materialId);
        id.getkitWorkOrder().setId(listWorkOrderId);

        suppliesMaterialJpaRepository.deleteById(id);

        return new ResponseEntity<SuppliesMaterial>(HttpStatus.NO_CONTENT);
    }
    
}
