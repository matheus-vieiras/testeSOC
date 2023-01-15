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

    public ExamesRealizados insert(ExamesRealizados obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public ExamesRealizados update(Long id, ExamesRealizados obj) {
        ExamesRealizados entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(ExamesRealizados entity, ExamesRealizados obj) {
        entity.setMoment(obj.getMoment());
        entity.setExames(obj.getExames());
        entity.setFuncionario(obj.getFuncionario());
    }
}

