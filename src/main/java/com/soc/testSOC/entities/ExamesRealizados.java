package com.soc.testSOC.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_exames_realizados")
public class ExamesRealizados implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exame_id")
    private Exames exames;

    @ManyToMany
    @JoinTable(name = "tb_func_exames_realizados",
            joinColumns = @JoinColumn(name = "exameRealizado_id"),
            inverseJoinColumns = @JoinColumn(name = "funcionario_id"))
    private List<Funcionario> funcionario = new ArrayList<>();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    public ExamesRealizados() {

    }

    public ExamesRealizados(Long id, Exames exames, Instant moment) {
        this.id = id;
        this.exames = exames;
        this.moment = moment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Exames getExames() {
        return exames;
    }

    public void setExames(Exames exames) {
        this.exames = exames;
    }

    public List<Funcionario> getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(List<Funcionario> funcionario) {
        this.funcionario = funcionario;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamesRealizados that = (ExamesRealizados) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
