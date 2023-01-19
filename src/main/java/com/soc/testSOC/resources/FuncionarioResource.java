package com.soc.testSOC.resources;

import com.soc.testSOC.entities.ExamesRealizados;
import com.soc.testSOC.entities.Funcionario;
import com.soc.testSOC.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioResource {

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public ResponseEntity<List<Funcionario>> findAll() {
        List<Funcionario> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Funcionario> findById(@PathVariable Long id) {
        Funcionario obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Object> insert(@RequestBody Funcionario obj) {
        if (service.existsByName(obj.getName())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Já existe um funcionario com o mesmo nome na base de dados!!!");
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
    public ResponseEntity<Funcionario> update(@PathVariable Long id, @RequestBody Funcionario obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
