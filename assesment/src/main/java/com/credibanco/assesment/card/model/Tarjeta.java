package com.credibanco.assesment.card.model;

import javax.persistence.*;

@Entity
@Table(name = "tarjeta")
public class Tarjeta {
    @Id
    @Column(name = "pan_tarjeta", nullable = false, length = 19)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_titular")
    private Titular idTitular;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_tarjeta")
    private TipoTarjeta tipoTarjeta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_tarjeta")
    private EstadoTarjeta estadoTarjeta;

    @Column(name = "num_validacion", length = 3)
    private String numValidacion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Titular getIdTitular() {
        return idTitular;
    }

    public void setIdTitular(Titular idTitular) {
        this.idTitular = idTitular;
    }

    public TipoTarjeta getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(TipoTarjeta tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public EstadoTarjeta getEstadoTarjeta() {
        return estadoTarjeta;
    }

    public void setEstadoTarjeta(EstadoTarjeta estadoTarjeta) {
        this.estadoTarjeta = estadoTarjeta;
    }

    public String getNumValidacion() {
        return numValidacion;
    }

    public void setNumValidacion(String numValidacion) {
        this.numValidacion = numValidacion;
    }

    @Override
    public String toString() {
        return "Tarjeta{" +
                "id='" + id + '\'' +
                ", idTitular=" + idTitular +
                ", tipoTarjeta=" + tipoTarjeta +
                ", estadoTarjeta=" + estadoTarjeta +
                ", numValidacion='" + numValidacion + '\'' +
                '}';
    }
}