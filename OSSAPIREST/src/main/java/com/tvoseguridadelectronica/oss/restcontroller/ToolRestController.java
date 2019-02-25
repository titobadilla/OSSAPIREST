package com.tvoseguridadelectronica.oss.restcontroller;

import com.tvoseguridadelectronica.oss.domain.Tool;
import com.tvoseguridadelectronica.oss.jparepository.ToolJpaRepository;
import com.tvoseguridadelectronica.oss.repository.ToolDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping({"/api/tool"})
public class ToolRestController {

    @Autowired
    private ToolJpaRepository toolJpaRepository;
    @Autowired
    private ToolDao toolDao;

    @GetMapping("/")
    public ResponseEntity<List<Tool>> listAllTool() {
        List<Tool> tools = toolJpaRepository.findAll();
        return new ResponseEntity<List<Tool>>(tools, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tool> createTool(@RequestBody final Tool tool) {
        toolJpaRepository.save(tool);
        return new ResponseEntity<Tool>(tool, HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tool> editTool(@PathVariable("id") final Integer id,@RequestBody final Tool tool) {

        Tool tool2 = toolJpaRepository.findById(id).get();

        tool2.setName(tool.getName());
        tool2.setDescription(tool.getDescription());
        tool2.setInventoryCategory(tool.getInventoryCategory());
        tool2.setMeasurementUnit(tool.getMeasurementUnit());

        toolJpaRepository.saveAndFlush(tool2);
        return new ResponseEntity<Tool>(tool2, HttpStatus.OK);
    }

    @PutMapping(value = "updateQuantity/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tool> editQuantityTool(@PathVariable("id") final Integer id,@RequestBody Tool tool) {
        Tool tool2=null;
        try {

            tool2 = toolJpaRepository.findById(id).get();

            tool2.setQuantity(tool.getQuantity());

            toolDao.updateTool(tool2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Tool>(tool2, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tool> findToolById(@PathVariable("id") final int id ) {
        Tool tool = toolJpaRepository.findById(id).get();
        return new ResponseEntity<Tool>(tool, HttpStatus.OK); 
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tool> deleteTool(@PathVariable("id") final int id) {
        toolJpaRepository.deleteById(id);
        return new ResponseEntity<Tool>(HttpStatus.NO_CONTENT);
    }

}
