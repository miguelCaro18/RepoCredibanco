package com.credibanco.assesment.card.dto;

public class ResCreateTransaction  extends  GenericResponse{

    private String estado;
    private String referencia;
    public ResCreateTransaction(String codigo_respuesta, String mensaje,String estado,String referencia) {
        super(codigo_respuesta, mensaje);
        this.estado=estado;
        this.referencia=referencia;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getEstado() {
        return estado;
    }

    public String getReferencia() {
        return referencia;
    }
}
