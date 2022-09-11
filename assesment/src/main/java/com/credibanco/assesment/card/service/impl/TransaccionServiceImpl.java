package com.credibanco.assesment.card.service.impl;

import com.credibanco.assesment.card.dto.ReqCancelTransaction;
import com.credibanco.assesment.card.dto.ReqCreateTransaction;
import com.credibanco.assesment.card.exceptions.TransactionErrorCard;
import com.credibanco.assesment.card.model.EstadoTransaccion;
import com.credibanco.assesment.card.model.Transaccion;
import com.credibanco.assesment.card.repository.TransaccionRepository;
import com.credibanco.assesment.card.service.CardService;
import com.credibanco.assesment.card.model.Tarjeta;
import com.credibanco.assesment.card.service.EstadoTransaccionService;
import com.credibanco.assesment.card.service.TransaccionService;
import com.credibanco.assesment.card.utils.Constants;
import com.credibanco.assesment.card.utils.UtilitiesTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;


@Service
public class TransaccionServiceImpl implements TransaccionService {

    @Autowired
    CardService cardService;

    @Autowired
    EstadoTransaccionService estadoTransaccionService;

    @Autowired
    TransaccionRepository transaccionRepository;
    @Override
    public Transaccion createTransaction(ReqCreateTransaction createTransaction) throws TransactionErrorCard {
        Optional<Tarjeta> tarjeta= cardService.FindCard(createTransaction.getPan_card());
        if(!tarjeta.isPresent())
            throw  new TransactionErrorCard("Tarjeta no existe","01","Rechazada",createTransaction.getNumero_referencia(), HttpStatus.BAD_REQUEST);
        System.out.println(tarjeta.get().toString());
        if(tarjeta.get().getEstadoTarjeta().getId() != Constants.ENROL_CARD)
            throw  new TransactionErrorCard("Tarjeta no enrolada","02","Rechazada",createTransaction.getNumero_referencia(), HttpStatus.BAD_REQUEST);
        List<Transaccion> transaccionList=transaccionRepository.getTransaccionByPanTarjetaAndReferencia(tarjeta.get(),createTransaction.getNumero_referencia());
        if(transaccionList.size()!=0)
            throw  new TransactionErrorCard("Tarjeta y Referencia Existen","03","Rechazada",createTransaction.getNumero_referencia(), HttpStatus.BAD_REQUEST);

        Transaccion t= new Transaccion();
        EstadoTransaccion estadoTransaccion=estadoTransaccionService.getEstadoTransaccionById(Constants.TRANSACTION_APPROVE).get();
        t.setPanTarjeta(tarjeta.get());
        t.setReferencia(createTransaction.getNumero_referencia());
        t.setDireccion(createTransaction.getDireccion_compra());
        t.setEstadoTransaccion(estadoTransaccion);
        t.setFechaTransaccion(Instant.now());
        t.setTotalCompra(createTransaction.getTotal_compra());
        return transaccionRepository.save(t);
    }

    @Override
    public Transaccion CancelTransaction(ReqCancelTransaction cancelTransaction) throws TransactionErrorCard {
        Optional<Tarjeta> tarjeta= cardService.FindCard(cancelTransaction.getPan_card());
        if(!tarjeta.isPresent())
            throw  new TransactionErrorCard("Tarjeta no existe","03",cancelTransaction.getNumero_referencia(),cancelTransaction.getNumero_referencia(), HttpStatus.BAD_REQUEST);
        List<Transaccion> transaccionList=transaccionRepository.getTransaccionByPanTarjetaAndReferencia(tarjeta.get(),cancelTransaction.getNumero_referencia());
        if(transaccionList.size()==0)
            throw  new TransactionErrorCard("número de referencia inválido","01","Rechazada",cancelTransaction.getNumero_referencia(), HttpStatus.BAD_REQUEST);
        Transaccion t=transaccionList.get(0);
        boolean timeLimit=UtilitiesTransaction.isLessThanNSeconds(t.getFechaTransaccion(),Instant.now(),60*5);
        if(!timeLimit)
            throw  new TransactionErrorCard("No se puede anular transacción","02",cancelTransaction.getNumero_referencia(),"Rechazada", HttpStatus.BAD_REQUEST);
        t.setEstadoTransaccion(estadoTransaccionService.getEstadoTransaccionById(Constants.TRANSACTION_CANCELED).get());
        return transaccionRepository.save(t);
    }
}
