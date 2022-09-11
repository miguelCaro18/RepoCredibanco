package com.credibanco.assesment.card.exceptions;

import org.springframework.http.HttpStatus;

public class TransactionErrorCard extends Exception{

    private HttpStatus errorStatus;
    private String codigoRespuesta;

    private String estado;

    private String referencia;


    public TransactionErrorCard(String message, String codigoRespuesta, String estado, String referencia, HttpStatus errorStatus){
        super(message);
        this.errorStatus=errorStatus;
        this.codigoRespuesta=codigoRespuesta;
        this.estado=estado;
        this.referencia=referencia;

    }

    public String getEstado() {
        return estado;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public HttpStatus getErrorStatus() {
        return errorStatus;
    }
}
