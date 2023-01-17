package com.soc.testSOC.config;

import com.soc.testSOC.entities.Exames;
import com.soc.testSOC.entities.ExamesRealizados;
import com.soc.testSOC.entities.Funcionario;
import com.soc.testSOC.repositories.ExamesRealizadosRepository;
import com.soc.testSOC.repositories.ExamesRepository;
import com.soc.testSOC.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
@Profile("test") // tem que ser igual ao do app.properties
public class TestConfig implements CommandLineRunner {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ExamesRepository examesRepository;

    @Autowired
    private ExamesRealizadosRepository examesRealizadosRepository;

    @Override
    public void run(String... args) throws Exception {

        Funcionario f1 = new Funcionario(null, "Alex");
        Funcionario f2 = new Funcionario(null, "Jordan");
        Funcionario f3 = new Funcionario(null, "Michael");

        Exames ex1 = new Exames(null, "RAIO-X");
        Exames ex2 = new Exames(null, "Ultrassonografia");
        Exames ex3 = new Exames(null, "Glicemia");

        ExamesRealizados er1 = new ExamesRealizados(null, ex1, LocalDate.parse("2023-01-17"));
        ExamesRealizados er2 = new ExamesRealizados(null, ex2, LocalDate.parse("2023-01-15"));
        ExamesRealizados er3 = new ExamesRealizados(null, ex3, LocalDate.parse("2023-01-12"));


        funcionarioRepository.saveAll(Arrays.asList(f1, f2, f3));
        examesRepository.saveAll(Arrays.asList(ex1, ex2, ex3));
        examesRealizadosRepository.saveAll(Arrays.asList(er1, er2, er3));

        er1.getFuncionario().add(f1);
        er1.getFuncionario().add(f2);
        er2.getFuncionario().add(f3);
        er3.getFuncionario().add(f1);

        examesRealizadosRepository.saveAll(Arrays.asList(er1, er2, er3));

    }
}

