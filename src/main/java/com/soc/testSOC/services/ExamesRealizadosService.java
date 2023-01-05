package com.soc.testSOC.services;

import com.soc.testSOC.entities.ExamesRealizados;
import com.soc.testSOC.repositories.ExamesRealizadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamesRealizadosService {

    @Autowired
    private ExamesRealizadosRepository repository;

    public List<ExamesRealizados> findAll() {
        return repository.findAll();
    }

    public ExamesRealizados findById(Long id) {
        Optional<ExamesRealizados> obj = repository.findById(id);
        return obj.get();
    }
}
