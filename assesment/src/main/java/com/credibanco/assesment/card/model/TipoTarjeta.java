package com.credibanco.assesment.card.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tipo_tarjeta")
public class TipoTarjeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @Column(name = "nombre_tipo", length = 100)
    private String nombreTipo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    @Override
    public String toString() {
        return "TipoTarjeta{" +
                "id=" + id +
                ", nombreTipo='" + nombreTipo + '\'' +
                '}';
    }
}