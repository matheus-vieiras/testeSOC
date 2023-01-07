package com.soc.testSOC.entities.pk;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.soc.testSOC.entities.Exames;
import com.soc.testSOC.entities.Funcionario;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;


@Embeddable
public class ExamesRealizadosPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "id_exame")
    private Exames exames;

    @ManyToOne
    @JoinColumn(name = "id_func")
    private Funcionario funcionario;

    public Exames getExames() {
        return exames;
    }

    public void setExames(Exames exames) {
        this.exames = exames;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamesRealizadosPK that = (ExamesRealizadosPK) o;
        return Objects.equals(exames, that.exames) && Objects.equals(funcionario, that.funcionario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exames, funcionario);
    }
}
