package com.credibanco.assesment.card.service;

import com.credibanco.assesment.card.dto.ReqCreateCard;
import com.credibanco.assesment.card.exceptions.GeneralErrorCard;
import com.credibanco.assesment.card.model.Tarjeta;

import java.util.Optional;

public interface CardService {

        Tarjeta createCard(ReqCreateCard t) throws GeneralErrorCard;

        Tarjeta enrollCard(String PANCard,String validateNumber) throws GeneralErrorCard;

        Optional<Tarjeta> FindCard(String PANCard);

        Tarjeta deleteCard(String PANCard,String ValidateNumber) throws GeneralErrorCard;

}
