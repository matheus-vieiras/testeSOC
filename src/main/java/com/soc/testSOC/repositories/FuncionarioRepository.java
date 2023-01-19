package com.soc.testSOC.repositories;

import com.soc.testSOC.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    boolean existsByName(String name);

}
