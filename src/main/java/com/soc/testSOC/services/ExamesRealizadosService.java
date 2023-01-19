package com.soc.testSOC.services;

import com.soc.testSOC.entities.Exames;
import com.soc.testSOC.entities.ExamesRealizados;
import com.soc.testSOC.entities.Funcionario;
import com.soc.testSOC.repositories.ExamesRealizadosRepository;
import com.soc.testSOC.repositories.ExamesRepository;
import com.soc.testSOC.repositories.FuncionarioRepository;
import com.soc.testSOC.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
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

        LocalDateTime today = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());

        LocalDateTime min = minDate.equals("") ? today.minusDays(365) : LocalDateTime.parse(minDate);

        LocalDateTime max = maxDate.equals("") ? today : LocalDateTime.parse(maxDate);

        return repository.findExamesRealizados(min, max, pageable);
    }

    public ExamesRealizados findById(Long id) {
        Optional<ExamesRealizados> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public ExamesRealizados insert(ExamesRealizados obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public ExamesRealizados update(Long id, ExamesRealizados obj) {
        try {
            ExamesRealizados entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(ExamesRealizados entity, ExamesRealizados obj) {
        entity.setDate(obj.getDate());
        entity.setExames(obj.getExames());
        entity.setFuncionario(obj.getFuncionario());
    }

    public boolean existsByDate(LocalDateTime date) {
        return repository.existsByDate(date);
    }

    public boolean existsByExames(String exames) {
        return repository.existsByExames(exames);
    }

    public boolean existsByFuncionario(String funcionario) {
        return repository.existsByFuncionario(funcionario);
    }
}

