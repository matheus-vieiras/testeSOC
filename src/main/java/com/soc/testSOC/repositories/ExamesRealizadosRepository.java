package com.soc.testSOC.repositories;

import com.soc.testSOC.entities.ExamesRealizados;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface ExamesRealizadosRepository extends JpaRepository<ExamesRealizados, Long> {

    @Query("SELECT obj FROM ExamesRealizados obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.exames DESC")
    Page<ExamesRealizados> findExamesRealizados(LocalDateTime min, LocalDateTime max, Pageable pageable);

}
