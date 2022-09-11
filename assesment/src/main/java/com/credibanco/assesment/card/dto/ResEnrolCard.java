package com.credibanco.assesment.card.dto;

import com.credibanco.assesment.card.utils.UtilitiesCard;

public class ResEnrolCard  extends  GenericResponse {
    private String PAN;

    public ResEnrolCard(String codigo_respuesta, String mensaje,String PAN) {
        super(codigo_respuesta, mensaje);
        this.PAN=PAN;
    }
    public String getPAN() {
        return UtilitiesCard.enmascararPAN(PAN,6,4);
    }
}
