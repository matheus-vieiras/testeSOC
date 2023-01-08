package com.soc.testSOC.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.soc.testSOC.entities.pk.ExamesRealizadosPK;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_exames")
public class Exames implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "id.exames")
    private List<ExamesRealizados> examesRealizados = new ArrayList<>();

    public Exames() {
    }

    public Exames(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ExamesRealizados> getExamesRealizados() {
        return examesRealizados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exames exames = (Exames) o;
        return id.equals(exames.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
