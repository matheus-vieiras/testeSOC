package com.soc.testSOC.services;

import com.soc.testSOC.entities.Exames;
import com.soc.testSOC.repositories.ExamesRepository;
import com.soc.testSOC.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamesService {

    @Autowired
    private ExamesRepository repository;

    public List<Exames> findAll() {
        return repository.findAll();
    }

    public Exames findById(Long id) {
        Optional<Exames> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Exames insert(Exames obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }
    }

    public Exames update(Long id, Exames obj) {
        try {
            Exames entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Exames entity, Exames obj) {
        entity.setName(obj.getName());
    }

    public boolean existsByName(String name) {
        return repository.existsByName(name);
    }
}
