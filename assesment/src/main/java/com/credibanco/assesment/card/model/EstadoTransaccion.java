package com.credibanco.assesment.card.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "estado_transaccion")
public class EstadoTransaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @Column(name = "nombre_estado", length = 100)
    private String nombreEstado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    @Override
    public String toString() {
        return "EstadoTransaccion{" +
                "id=" + id +
                ", nombreEstado='" + nombreEstado + '\'' +
                '}';
    }
}