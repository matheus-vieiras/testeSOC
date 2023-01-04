package com.soc.testSOC.resources;

import com.soc.testSOC.entities.Funcionario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioResource {

    @GetMapping
    public ResponseEntity<Funcionario> findAll() {
        Funcionario f = new Funcionario(1L, "Maria");
        return ResponseEntity.ok().body(f);
    }
}
