package com.soc.testSOC.resources;

import com.soc.testSOC.entities.ExamesRealizados;
import com.soc.testSOC.services.ExamesRealizadosService;
import com.soc.testSOC.services.ExamesService;
import com.soc.testSOC.services.FuncionarioService;
import com.soc.testSOC.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/exames-realizados")
public class ExamesRealizadosResource {

    @Autowired
    private ExamesRealizadosService service;

    @Autowired
    private FuncionarioService funcService;

    @Autowired
    private ExamesService examesService;

    @GetMapping
    public ResponseEntity<Page<ExamesRealizados>> findAll(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC)
            Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable));
    }

    @GetMapping(value = "/search-date")
    public Page<ExamesRealizados> findExamesRealizados(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return service.findExamesRealizados(minDate, maxDate, pageable);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ExamesRealizados> findById(@PathVariable Long id) {
        ExamesRealizados obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Object> insert(@RequestBody ExamesRealizados obj) {
        try {
            if (service.existsByDate(obj.getDate()) && service.existsByExames(obj.getExames().getName()) && service.existsByFuncionario(obj.getFuncionario().toString())) {
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Duplicidade ao registrar o exame realizado. VERIFIQUE!!!");
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
    public ResponseEntity<ExamesRealizados> update(@PathVariable Long id, @RequestBody ExamesRealizados obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}

