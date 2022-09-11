package com.credibanco.assesment.card.service.impl;

import com.credibanco.assesment.card.dto.ReqCreateCard;
import com.credibanco.assesment.card.exceptions.GeneralErrorCard;
import com.credibanco.assesment.card.model.EstadoTarjeta;
import com.credibanco.assesment.card.model.Tarjeta;
import com.credibanco.assesment.card.model.TipoTarjeta;
import com.credibanco.assesment.card.model.Titular;
import com.credibanco.assesment.card.repository.EstadoTarjetaRepository;
import com.credibanco.assesment.card.repository.TarjetaRepository;
import com.credibanco.assesment.card.service.CardService;
import com.credibanco.assesment.card.service.EstadoTarjetaService;
import com.credibanco.assesment.card.service.TipoTarjetaService;
import com.credibanco.assesment.card.service.TitularService;
import com.credibanco.assesment.card.utils.Constants;
import com.credibanco.assesment.card.utils.UtilitiesCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {


@Autowired
    TipoTarjetaService tipoTarjetaService;
    @Autowired
    TarjetaRepository tarjetaRepository;
    @Autowired
    TitularService titularService;
    @Autowired
    EstadoTarjetaService estadoTarjetaService;

    @Override
    public Tarjeta createCard(ReqCreateCard t) throws GeneralErrorCard {
        if(FindCard(t.getPan_card()).isPresent())
            throw new GeneralErrorCard("Mensaje Fallido","01", HttpStatus.CONFLICT);
        Titular titular= new Titular();
        titular.setTelefonoTitular(t.getTelefono());
        titular.setCedulaTitular(t.getCedula());
        titular.setNombreTitular(t.getNombre_titular());
        Titular titular1=titularService.createTitular(titular);
        EstadoTarjeta stateCreated= estadoTarjetaService.getEstadoTarjetaById(Constants.CREATED_CARD).get();
        TipoTarjeta tipoTarjeta=tipoTarjetaService.getTipoTarjetaById(t.getTipo().equals(Constants.CREDITO)?Constants.TYPE_CREDIT:Constants.TYPE_DEBIT).get();
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.setId(t.getPan_card());
        tarjeta.setEstadoTarjeta(stateCreated);
        tarjeta.setTipoTarjeta(tipoTarjeta);
        tarjeta.setIdTitular(titular1);
        tarjeta.setNumValidacion(UtilitiesCard.getValidateNumberTo099());
        return tarjetaRepository.save(tarjeta);
    }

    @Override
    public Tarjeta enrollCard(String PANCard,String validateNumber) throws GeneralErrorCard {
        Optional<Tarjeta> tarjeta=FindCard(PANCard);
        if(!tarjeta.isPresent() || tarjeta.get().getEstadoTarjeta().getId().intValue()==Constants.DELETED_CARD)
            throw new GeneralErrorCard("Tarjeta no existe","01", HttpStatus.CONFLICT);
        if(!tarjeta.get().getNumValidacion().equals(validateNumber))
            throw new GeneralErrorCard("Número de validación inválido","02", HttpStatus.UNPROCESSABLE_ENTITY);
        if(tarjeta.get().getEstadoTarjeta().getId().intValue()==Constants.ENROL_CARD)
            throw new GeneralErrorCard("No se modificó","03", HttpStatus.CONFLICT);
        Tarjeta tSave=tarjeta.get();
        tSave.setEstadoTarjeta(estadoTarjetaService.getEstadoTarjetaById(Constants.ENROL_CARD).get());
        return tarjetaRepository.save(tSave);
    }

    @Override
    public Optional<Tarjeta> FindCard(String PANCard) {
        return tarjetaRepository.findById(PANCard);
    }

    @Override
    public Tarjeta deleteCard(String PANCard,String validateNumber) throws GeneralErrorCard {
        Optional<Tarjeta> tarjeta=FindCard(PANCard);
        if(!tarjeta.isPresent() || tarjeta.get().getEstadoTarjeta().getId().intValue()==Constants.DELETED_CARD )
            throw new GeneralErrorCard("Tarjeta no existe","01", HttpStatus.CONFLICT);
        if(!tarjeta.get().getNumValidacion().equals(validateNumber))
            throw new GeneralErrorCard("Número de validación inválido","02", HttpStatus.UNPROCESSABLE_ENTITY);
        Tarjeta tSave=tarjeta.get();
        tSave.setEstadoTarjeta(estadoTarjetaService.getEstadoTarjetaById(Constants.DELETED_CARD).get());
        return tarjetaRepository.save(tSave);
    }

}
