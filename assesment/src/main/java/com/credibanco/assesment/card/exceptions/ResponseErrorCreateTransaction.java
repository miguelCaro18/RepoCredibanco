package com.credibanco.assesment.card.exceptions;

public class ResponseErrorCreateTransaction extends  ResponseErrorCard{
    private String estado;
    private String referencia;

    public ResponseErrorCreateTransaction(String codigoRespuesta, String mensaje,String estado, String referencia) {
        super(codigoRespuesta, mensaje);
        this.estado=estado;
        this.referencia=referencia;
    }

    public String getEstado() {
        return estado;
    }

    public String getReferencia() {
        return referencia;
    }
}
