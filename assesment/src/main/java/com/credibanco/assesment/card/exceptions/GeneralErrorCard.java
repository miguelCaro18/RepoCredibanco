package com.credibanco.assesment.card.exceptions;

import org.springframework.http.HttpStatus;

public class GeneralErrorCard extends Exception{

    private HttpStatus errorStatus;
    private String codigoRespuesta;


    public GeneralErrorCard(String message, String codigoRespuesta,HttpStatus errorStatus){
        super(message);
        this.errorStatus=errorStatus;
        this.codigoRespuesta=codigoRespuesta;

    }

    public String getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public HttpStatus getErrorStatus() {
        return errorStatus;
    }
}
