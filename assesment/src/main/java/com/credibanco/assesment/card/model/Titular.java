package com.credibanco.assesment.card.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "titular")
public class Titular {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 300)
    @Column(name = "nombre_titular", length = 300)
    private String nombreTitular;

    @Size(max = 10)
    @Column(name = "telefono_titular", length = 10)
    private String telefonoTitular;

    @Size(max = 15)
    @Column(name = "cedula_titular", length = 15)
    private String cedulaTitular;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getTelefonoTitular() {
        return telefonoTitular;
    }

    public void setTelefonoTitular(String telefonoTitular) {
        this.telefonoTitular = telefonoTitular;
    }

    public String getCedulaTitular() {
        return cedulaTitular;
    }

    public void setCedulaTitular(String cedulaTitular) {
        this.cedulaTitular = cedulaTitular;
    }


    @Override
    public String toString() {
        return "Titular{" +
                "id=" + id +
                ", nombreTitular='" + nombreTitular + '\'' +
                ", telefonoTitular='" + telefonoTitular + '\'' +
                ", cedulaTitular='" + cedulaTitular + '\'' +
                '}';
    }
}