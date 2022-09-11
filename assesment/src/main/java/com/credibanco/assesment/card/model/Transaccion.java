package com.credibanco.assesment.card.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "transaccion")
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pan_tarjeta")
    private Tarjeta panTarjeta;

    @Column(name = "total_compra")
    private Double totalCompra;

    @Column(name = "direccion", length = 200)
    private String direccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_transaccion")
    private EstadoTransaccion estadoTransaccion;

    @Column(name = "referencia", length = 6,unique = true)
    private String referencia;

    @Column(name = "fecha_transaccion")
    private Instant fechaTransaccion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tarjeta getPanTarjeta() {
        return panTarjeta;
    }

    public void setPanTarjeta(Tarjeta panTarjeta) {
        this.panTarjeta = panTarjeta;
    }

    public Double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public EstadoTransaccion getEstadoTransaccion() {
        return estadoTransaccion;
    }

    public void setEstadoTransaccion(EstadoTransaccion estadoTransaccion) {
        this.estadoTransaccion = estadoTransaccion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Instant getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Instant fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "id=" + id +
                ", panTarjeta=" + panTarjeta +
                ", totalCompra=" + totalCompra +
                ", direccion='" + direccion + '\'' +
                ", estadoTransaccion=" + estadoTransaccion +
                ", referencia='" + referencia + '\'' +
                ", fechaTransaccion=" + fechaTransaccion +
                '}';
    }
}