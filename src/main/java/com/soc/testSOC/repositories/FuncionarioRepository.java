package com.soc.testSOC.repositories;

import com.soc.testSOC.entities.ExamesRealizados;
import com.soc.testSOC.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    boolean existsByName(String name);
}
