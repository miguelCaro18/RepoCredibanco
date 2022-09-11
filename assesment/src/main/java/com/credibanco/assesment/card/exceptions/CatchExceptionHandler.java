package com.credibanco.assesment.card.exceptions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CatchExceptionHandler {


    @ExceptionHandler(GeneralErrorCard.class)
    public ResponseEntity<?> commonException(GeneralErrorCard ex, WebRequest request) {
        ResponseErrorCard responseErrorCard = new ResponseErrorCard(ex.getCodigoRespuesta(),ex.getMessage());
        return new ResponseEntity<>(responseErrorCard, ex.getErrorStatus());
    }
    @ExceptionHandler(TransactionErrorCard.class)
    public ResponseEntity<?> transactionException(TransactionErrorCard ex, WebRequest request) {
        ResponseErrorCreateTransaction responseErrorCard = new ResponseErrorCreateTransaction(ex.getCodigoRespuesta(),ex.getMessage(),ex.getEstado(),ex.getReferencia());
        return new ResponseEntity<>(responseErrorCard, ex.getErrorStatus());
    }


}

