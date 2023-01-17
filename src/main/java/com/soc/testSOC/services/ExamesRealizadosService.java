package com.soc.testSOC.services;

import com.soc.testSOC.entities.ExamesRealizados;
import com.soc.testSOC.repositories.ExamesRealizadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
public class ExamesRealizadosService {

    @Autowired
    private ExamesRealizadosRepository repository;

    public Page<ExamesRealizados> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<ExamesRealizados> findExamesRealizados(String minDate, String maxDate, Pageable pageable) {

        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
        // expressão condicional ternária
        LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);

        return repository.findExamesRealizados(min, max, pageable);
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
//        entity.setMoment(obj.getMoment());
        entity.setDate(obj.getDate());
        entity.setExames(obj.getExames());
        entity.setFuncionario(obj.getFuncionario());
    }
}

