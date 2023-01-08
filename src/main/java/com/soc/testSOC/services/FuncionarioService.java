package com.soc.testSOC.services;

import com.soc.testSOC.entities.Funcionario;
import com.soc.testSOC.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public List<Funcionario> findAll() {
        return repository.findAll();
    }

    public Funcionario findById(Long id) {
        Optional<Funcionario> obj = repository.findById(id);
        return obj.get();
    }

    public Funcionario insert(Funcionario obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
