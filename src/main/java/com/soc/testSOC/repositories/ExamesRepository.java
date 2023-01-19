package com.soc.testSOC.repositories;

import com.soc.testSOC.entities.Exames;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamesRepository extends JpaRepository<Exames, Long> {

    boolean existsByName(String name);

}
