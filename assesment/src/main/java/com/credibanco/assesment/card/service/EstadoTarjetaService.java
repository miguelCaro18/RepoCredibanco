package com.credibanco.assesment.card.service;


import com.credibanco.assesment.card.model.EstadoTarjeta;

import java.util.Optional;

public interface EstadoTarjetaService {
    Optional<EstadoTarjeta> getEstadoTarjetaById(Integer id);

}
