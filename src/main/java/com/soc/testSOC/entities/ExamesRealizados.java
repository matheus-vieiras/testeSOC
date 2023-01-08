package com.soc.testSOC.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.soc.testSOC.entities.pk.ExamesRealizadosPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_exames_realizados")
public class ExamesRealizados implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ExamesRealizadosPK id = new ExamesRealizadosPK();

    private Instant moment;

    public ExamesRealizados() {
    }

    public ExamesRealizados(Exames exames, Funcionario funcionario, Instant moment) {
        id.setExames(exames);
        id.setFuncionario(funcionario);
        this.moment = moment;
    }

    @JsonIgnore
    public Exames getExames() {
        return id.getExames();
    }

    public void setExames(Exames exames) {
        id.setExames(exames);
    }

    public Funcionario getFuncionario() {
        return id.getFuncionario();
    }

    public void setFuncionario(Funcionario funcionario) {
        id.setFuncionario(funcionario);
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

}
