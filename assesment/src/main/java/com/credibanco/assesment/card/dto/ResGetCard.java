package com.credibanco.assesment.card.dto;

import com.credibanco.assesment.card.utils.UtilitiesCard;

public class ResGetCard  extends  GenericResponse{


    private String PAN;
    private String titular;
    private String cedula;
    private String telefono;
    private String estado;

    public ResGetCard(String codigo_respuesta, String mensaje, String PAN, String titular, String cedula, String telefono, String estado) {
        super(codigo_respuesta, mensaje);
        this.PAN = PAN;
        this.titular = titular;
        this.cedula = cedula;
        this.telefono = telefono;
        this.estado = estado;
    }

    public String getPAN() {
        return UtilitiesCard.enmascararPAN(PAN,6,4);
    }


    public void setPAN(String PAN) {
        this.PAN = PAN;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
