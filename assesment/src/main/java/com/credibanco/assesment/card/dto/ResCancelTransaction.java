package com.credibanco.assesment.card.dto;

public class ResCancelTransaction  extends  GenericResponse{


    private String referencia;

    public ResCancelTransaction(String codigo_respuesta, String mensaje,String referencia) {
        super(codigo_respuesta, mensaje);
        this.referencia=referencia;
    }



    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }



    public String getReferencia() {
        return referencia;
    }
}
