package com.soc.testSOC.services;

import com.soc.testSOC.entities.Exames;
import com.soc.testSOC.repositories.ExamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return obj.get();
    }

    public Exames insert(Exames obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Exames update(Long id, Exames obj) {
        Exames entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Exames entity, Exames obj) {
        entity.setName(obj.getName());
    }
}
