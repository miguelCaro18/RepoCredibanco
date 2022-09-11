package com.credibanco.assesment.card.service;

import com.credibanco.assesment.card.model.TipoTarjeta;

import java.util.Optional;

public interface TipoTarjetaService {

    Optional<TipoTarjeta> getTipoTarjetaById(Integer id);
}
