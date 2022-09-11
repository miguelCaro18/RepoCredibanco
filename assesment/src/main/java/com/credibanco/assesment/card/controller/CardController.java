package com.credibanco.assesment.card.controller;


import com.credibanco.assesment.card.dto.*;
import com.credibanco.assesment.card.exceptions.GeneralErrorCard;
import com.credibanco.assesment.card.service.CardService;
import com.credibanco.assesment.card.model.Tarjeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("/api/card")
public class CardController {


    @Autowired
    CardService cardService;


    @PostMapping()
    public ResponseEntity<?> CreateCard(@Valid @RequestBody ReqCreateCard reqCreateCard, BindingResult bindingResult) throws GeneralErrorCard {

        if(bindingResult.hasErrors()){
            StringBuilder errors=new StringBuilder();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errors.append(error.getDefaultMessage());
                errors.append(",");
            }
            errors.deleteCharAt(errors.lastIndexOf(","));
            throw new GeneralErrorCard("Error en los datos Ingresados "+errors.toString(),"02", HttpStatus.BAD_REQUEST);
        }
        // Validaciones correctas pasar a validar con la base de datos la información
        Tarjeta tarjeta=cardService.createCard(reqCreateCard);
        ResCreateCard resCreateCard= new ResCreateCard("01","Éxito",tarjeta.getNumValidacion(),tarjeta.getId());
        return new ResponseEntity<>(resCreateCard,HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<?> enrolCard(@Valid @RequestBody ReqEnrolAndDeleteCard reqEnrolAndDeleteCard, BindingResult bindingResult) throws GeneralErrorCard {
        if(bindingResult.hasErrors()){
            StringBuilder errors=new StringBuilder();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errors.append(error.getDefaultMessage());
                errors.append(",");
            }
            errors.deleteCharAt(errors.lastIndexOf(","));
            throw new GeneralErrorCard("Error en los datos Ingresados "+errors.toString(),"04", HttpStatus.BAD_REQUEST);
        }
        Tarjeta tarjeta=cardService.enrollCard(reqEnrolAndDeleteCard.getPan_card(), reqEnrolAndDeleteCard.getNumeroValidacion());
        ResEnrolCard resEnrolCard=new ResEnrolCard("00","Éxito",tarjeta.getId());

        return new ResponseEntity<>(resEnrolCard,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTarjeta(@PathVariable("id") String id) throws GeneralErrorCard {
        Optional<Tarjeta> t= cardService.FindCard(id);
        if(!t.isPresent())
            throw new GeneralErrorCard("Tarjeta no existe","01", HttpStatus.BAD_REQUEST);
        ResGetCard resGetCard=new ResGetCard("00","Éxito",t.get().getId(),t.get().getIdTitular().getNombreTitular(),t.get().getIdTitular().getCedulaTitular(),t.get().getIdTitular().getTelefonoTitular(),t.get().getEstadoTarjeta().getNombreEstado());
        return new ResponseEntity<>(resGetCard,HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteCard(@Valid @RequestBody ReqEnrolAndDeleteCard reqEnrolAndDeleteCard, BindingResult bindingResult) throws GeneralErrorCard {
        if(bindingResult.hasErrors()){
            StringBuilder errors=new StringBuilder();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errors.append(error.getDefaultMessage());
                errors.append(",");
            }
            errors.deleteCharAt(errors.lastIndexOf(","));
            throw new GeneralErrorCard("Error en los datos Ingresados "+errors.toString(),"04", HttpStatus.BAD_REQUEST);
        }
        cardService.deleteCard(reqEnrolAndDeleteCard.getPan_card(), reqEnrolAndDeleteCard.getNumeroValidacion());
        GenericResponse genericResponse= new GenericResponse("00","Se ha eliminado la tarjeta");
        return new ResponseEntity<>(genericResponse,HttpStatus.OK);
    }


}
