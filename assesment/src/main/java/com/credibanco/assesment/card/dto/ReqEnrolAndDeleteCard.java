package com.credibanco.assesment.card.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ReqEnrolAndDeleteCard {

    @NotBlank(message = "pan_card is necesary")
    @Size(max = 19,message = "pan_card should be at most 19")
    @Size(min = 16,message = "pan_card should be at least 16")
    private String pan_card;

    @NotBlank(message = "numeroValidacion is necesary")
    @Pattern(regexp = "^\\d{3}$", message = "numeroValidacion should be only numeric and 3 digits ")
    private String numeroValidacion;

    public String getPan_card() {
        return pan_card;
    }

    public void setPan_card(String pan_card) {
        this.pan_card = pan_card;
    }

    public String getNumeroValidacion() {
        return numeroValidacion;
    }

    public void setNumeroValidacion(String numeroValidacion) {
        this.numeroValidacion = numeroValidacion;
    }
}
