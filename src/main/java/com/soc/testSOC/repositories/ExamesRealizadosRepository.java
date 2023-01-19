package com.soc.testSOC.repositories;

import com.soc.testSOC.entities.ExamesRealizados;
import com.soc.testSOC.entities.Funcionario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public interface ExamesRealizadosRepository extends JpaRepository<ExamesRealizados, Long> {

    @Query("SELECT obj FROM ExamesRealizados obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.exames DESC")
    Page<ExamesRealizados> findExamesRealizados(LocalDateTime min, LocalDateTime max, Pageable pageable);

    boolean existsByDate(LocalDateTime date);

    boolean existsByExames(String name);

    boolean existsByFuncionario(String name);
}
