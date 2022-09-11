package com.credibanco.assesment.card.dto;

import com.credibanco.assesment.card.utils.Constants;
import com.credibanco.assesment.card.validatorEnum.EnumValidator;

import javax.validation.constraints.*;

public class ReqCreateCard   {

    @NotBlank(message = "pan_card is necesary")
    @Size(max = 19,message = "pan_card should be at most 19")
    @Size(min = 16,message = "pan_card should be at least 16")
    @Pattern(regexp = "[0-9]*", message = "pan_card should be only numeric")
    private String pan_card;

    @NotBlank(message = "nombre_titular is necesary")
    private String nombre_titular;

    @NotBlank(message = "cedula is necesary")
    @Size(max = 15,message = "cedula should be at most 15")
    @Size(min = 10,message = "cedula should be at least 10")
    private String cedula;

    @NotBlank(message = "tipo is necesary")
    @EnumValidator(acceptedValues={Constants.CREDITO, Constants.DEBITO}, message="Invalid dataType for Tipo, is Credito or Debito")
    private String tipo;

    @NotBlank(message = "telefono is necesary")
    @Pattern(regexp = "^\\d{10}$", message = "Telefono should be only numeric and 10 digits ")
    private String telefono;

    public String getPan_card() {
        return pan_card;
    }

    public void setPan_card(String pan_card) {
        this.pan_card = pan_card;
    }

    public String getNombre_titular() {
        return nombre_titular;
    }

    public void setNombre_titular(String nombre_titular) {
        this.nombre_titular = nombre_titular;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "ReqCreateCard{" +
                "pan_card='" + pan_card + '\'' +
                ", nombre_titular='" + nombre_titular + '\'' +
                ", cedula='" + cedula + '\'' +
                ", tipo='" + tipo + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
