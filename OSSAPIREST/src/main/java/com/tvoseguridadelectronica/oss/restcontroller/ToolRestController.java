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

    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tool> editTool(@RequestBody final Tool tool) {
        toolJpaRepository.saveAndFlush(tool);
        return new ResponseEntity<Tool>(tool, HttpStatus.OK);
    }

    @PutMapping(value = "updateQuantity/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tool> editQuantityTool(@RequestBody Tool tool) {
        try {
            tool = toolDao.updateTool(tool);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Tool>(tool, HttpStatus.OK);
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
