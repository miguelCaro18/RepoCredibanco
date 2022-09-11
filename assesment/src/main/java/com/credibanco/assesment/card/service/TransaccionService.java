package com.credibanco.assesment.card.service;

import com.credibanco.assesment.card.dto.ReqCancelTransaction;
import com.credibanco.assesment.card.dto.ReqCreateTransaction;
import com.credibanco.assesment.card.exceptions.TransactionErrorCard;
import com.credibanco.assesment.card.model.Transaccion;

public interface TransaccionService {

        Transaccion createTransaction(ReqCreateTransaction createTransaction) throws TransactionErrorCard;

        Transaccion CancelTransaction(ReqCancelTransaction cancelTransaction) throws TransactionErrorCard;



}
