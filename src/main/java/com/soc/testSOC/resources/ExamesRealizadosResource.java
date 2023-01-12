package com.soc.testSOC.resources;

import com.soc.testSOC.entities.ExamesRealizados;
import com.soc.testSOC.services.ExamesRealizadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/exames-realizados")
public class ExamesRealizadosResource {

    @Autowired
    private ExamesRealizadosService service;

    @GetMapping
    public ResponseEntity<List<ExamesRealizados>> findAll() {
        List<ExamesRealizados> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ExamesRealizados> findById(@PathVariable Long id) {
        ExamesRealizados obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<ExamesRealizados> insert(@RequestBody ExamesRealizados obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ExamesRealizados> update(@PathVariable Long id, @RequestBody ExamesRealizados obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}

