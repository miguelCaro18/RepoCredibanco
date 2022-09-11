package com.credibanco.assesment.card.dto;

public class GenericResponse {

    private String codigo_respuesta;
    private String mensaje;

    public GenericResponse(String codigo_respuesta, String mensaje) {
        this.codigo_respuesta = codigo_respuesta;
        this.mensaje = mensaje;
    }

    public String getCodigo_respuesta() {
        return codigo_respuesta;
    }

    public void setCodigo_respuesta(String codigo_respuesta) {
        this.codigo_respuesta = codigo_respuesta;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
