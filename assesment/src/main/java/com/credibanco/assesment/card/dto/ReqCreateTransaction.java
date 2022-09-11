package com.credibanco.assesment.card.dto;

import com.credibanco.assesment.card.utils.Constants;
import com.credibanco.assesment.card.validatorEnum.EnumValidator;

import javax.validation.constraints.*;

public class ReqCreateTransaction {

    @NotBlank(message = "pan_card is necesary")
    @Size(max = 19,message = "pan_card should be at most 19")
    @Size(min = 16,message = "pan_card should be at least 16")
    @Pattern(regexp = "[0-9]*", message = "pan_card should be only numeric")
    private String pan_card;

    @NotBlank(message = "numero_referencia is necesary")
    @Pattern(regexp = "^\\d{6}$", message = "numero_referencia should be only numeric and 6 digits ")
    private String numero_referencia;

    @NotNull(message = "total_compra is necesary")
    private Double total_compra;

    @NotBlank(message = "direccion_compra is necesary")
    private String direccion_compra;

    public String getPan_card() {
        return pan_card;
    }

    public void setPan_card(String pan_card) {
        this.pan_card = pan_card;
    }

    public String getNumero_referencia() {
        return numero_referencia;
    }

    public void setNumero_referencia(String numero_referencia) {
        this.numero_referencia = numero_referencia;
    }

    public Double getTotal_compra() {
        return total_compra;
    }

    public void setTotal_compra(Double total_compra) {
        this.total_compra = total_compra;
    }

    public String getDireccion_compra() {
        return direccion_compra;
    }

    public void setDireccion_compra(String direccion_compra) {
        this.direccion_compra = direccion_compra;
    }
}
