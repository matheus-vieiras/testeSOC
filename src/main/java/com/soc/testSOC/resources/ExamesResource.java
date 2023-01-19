package com.soc.testSOC.resources;

import com.soc.testSOC.entities.Exames;
import com.soc.testSOC.services.ExamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Object> insert(@RequestBody Exames obj) {
        if (service.existsByName(obj.getName())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Já existe um exame com o mesmo nome cadastrado!!!");

        }
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
    public ResponseEntity<Exames> update(@PathVariable Long id, @RequestBody Exames obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}

