package com.credibanco.assesment.card.service.impl;

import com.credibanco.assesment.card.model.EstadoTarjeta;
import com.credibanco.assesment.card.model.TipoTarjeta;
import com.credibanco.assesment.card.repository.EstadoTarjetaRepository;
import com.credibanco.assesment.card.repository.TipoTarjetaRepository;
import com.credibanco.assesment.card.service.EstadoTarjetaService;
import com.credibanco.assesment.card.service.TipoTarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TipoTarjetaServiceImpl implements TipoTarjetaService {

    @Autowired
    TipoTarjetaRepository tipoTarjetaRepository;


    @Override
    public Optional<TipoTarjeta> getTipoTarjetaById(Integer id) {
        return tipoTarjetaRepository.findById(id);
    }

}
