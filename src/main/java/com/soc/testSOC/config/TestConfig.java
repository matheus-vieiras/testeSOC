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
import java.util.Arrays;

@Configuration
@Profile("test") // tem que ser igual ao do app.properties
public class TestConfig implements CommandLineRunner {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ExamesRealizadosRepository exRealizadosRepository;

    @Autowired
    private ExamesRepository examesRepository;

    @Override
    public void run(String... args) throws Exception {

        Funcionario f1 = new Funcionario(null, "Alex");
        Funcionario f2 = new Funcionario(null, "Jordan");
        Funcionario f3 = new Funcionario(null, "Michael");

        Exames ex1 = new Exames(null, "RAIO-X");
        Exames ex2 = new Exames(null, "Ultrassonografia");

        ExamesRealizados er1 = new ExamesRealizados(null, Instant.parse("2023-01-05T16:15:10Z"), f1, ex1);
        ExamesRealizados er2 = new ExamesRealizados(null, Instant.parse("2023-01-08T07:30:22Z"), f2, ex2);
        ExamesRealizados er3 = new ExamesRealizados(null, Instant.parse("2023-01-05T16:15:10Z"), f3, ex1);


        funcionarioRepository.saveAll(Arrays.asList(f1, f2, f3));
        examesRepository.saveAll(Arrays.asList(ex1, ex2));
        exRealizadosRepository.saveAll(Arrays.asList(er1, er2, er3));


    }
}

