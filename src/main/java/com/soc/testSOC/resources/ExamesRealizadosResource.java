package com.soc.testSOC.resources;

import com.soc.testSOC.entities.ExamesRealizados;
import com.soc.testSOC.entities.Funcionario;
import com.soc.testSOC.services.ExamesRealizadosService;
import com.soc.testSOC.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/examesrealizados")
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
}
