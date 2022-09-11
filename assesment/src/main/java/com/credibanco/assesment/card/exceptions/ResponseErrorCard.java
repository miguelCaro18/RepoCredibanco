package com.credibanco.assesment.card.exceptions;

public class ResponseErrorCard {
    private String codigoRespuesta;
    private String mensaje;

    public ResponseErrorCard(String codigoRespuesta, String mensaje) {
        this.codigoRespuesta = codigoRespuesta;
        this.mensaje = mensaje;
    }


    public String getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public void setCodigoRespuesta(String status) {
        this.codigoRespuesta = status;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
