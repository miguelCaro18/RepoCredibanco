package com.credibanco.assesment.card.service;


import com.credibanco.assesment.card.model.EstadoTarjeta;
import com.credibanco.assesment.card.model.EstadoTransaccion;

import java.util.Optional;

public interface EstadoTransaccionService {
    Optional<EstadoTransaccion> getEstadoTransaccionById(Integer id);

}
