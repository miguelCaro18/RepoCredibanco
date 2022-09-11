package com.credibanco.assesment.card.dto;

import com.credibanco.assesment.card.utils.UtilitiesCard;

public class ResCreateCard extends  GenericResponse{

    private String numeroValidacion;
    private String PAN;

    public ResCreateCard(String codigo_respuesta, String mensaje,String numeroValidacion,String PAN) {
        super(codigo_respuesta, mensaje);
        this.numeroValidacion=numeroValidacion;
        this.PAN=PAN;
    }

    public String getNumeroValidacion() {
        return numeroValidacion;
    }

    public void setNumeroValidacion(String numeroValidacion) {
        this.numeroValidacion = numeroValidacion;
    }

    public String getPAN() {
        return UtilitiesCard.enmascararPAN(PAN,6,4);
    }

    public void setPAN(String PAN) {
        this.PAN = PAN;
    }
}
