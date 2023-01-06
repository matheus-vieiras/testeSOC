package com.soc.testSOC.resources;

import com.soc.testSOC.entities.Exames;
import com.soc.testSOC.services.ExamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/exames")
public class ExamesResource {

    @Autowired
    private ExamesService service;

    @GetMapping
    public ResponseEntity<List<Exames>> findAll() {
        List<Exames> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Exames> findById(@PathVariable Long id) {
        Exames obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
