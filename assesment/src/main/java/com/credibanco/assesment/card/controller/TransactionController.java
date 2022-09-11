package com.credibanco.assesment.card.controller;


import com.credibanco.assesment.card.dto.*;
import com.credibanco.assesment.card.exceptions.TransactionErrorCard;
import com.credibanco.assesment.card.exceptions.GeneralErrorCard;
import com.credibanco.assesment.card.model.Transaccion;
import com.credibanco.assesment.card.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/transaction")
public class TransactionController {


    @Autowired
    TransaccionService transaccionService;


    @PostMapping("/create")
    public ResponseEntity<?> CreateTransaction(@Valid @RequestBody ReqCreateTransaction reqCreateTransaction, BindingResult bindingResult) throws TransactionErrorCard, GeneralErrorCard {
        if(bindingResult.hasErrors()){
            StringBuilder errors=new StringBuilder();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errors.append(error.getDefaultMessage());
                errors.append(",");
            }
            errors.deleteCharAt(errors.lastIndexOf(","));
            throw new GeneralErrorCard("Error en los datos Ingresados "+errors.toString(),"04", HttpStatus.BAD_REQUEST);
        }
        Transaccion t= transaccionService.createTransaction(reqCreateTransaction);
        ResCreateTransaction resCreateTransaction=new ResCreateTransaction("00","Compra Exitosa","Aprobada",t.getReferencia());
        return new ResponseEntity<>(resCreateTransaction,HttpStatus.CREATED);
    }

    @PutMapping("/cancel")
    public ResponseEntity<?> cancelTransaction(@Valid @RequestBody ReqCancelTransaction reqCancelTransaction, BindingResult bindingResult) throws TransactionErrorCard, GeneralErrorCard {
        if(bindingResult.hasErrors()){
            StringBuilder errors=new StringBuilder();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errors.append(error.getDefaultMessage());
                errors.append(",");
            }
            errors.deleteCharAt(errors.lastIndexOf(","));
            throw new GeneralErrorCard("Error en los datos Ingresados "+errors.toString(),"04", HttpStatus.BAD_REQUEST);
        }
        Transaccion t=transaccionService.CancelTransaction(reqCancelTransaction);
        ResCancelTransaction resCancelTransaction=new ResCancelTransaction("00","Compra anulada",t.getReferencia());
        return new ResponseEntity<>(resCancelTransaction,HttpStatus.OK);
    }



}
