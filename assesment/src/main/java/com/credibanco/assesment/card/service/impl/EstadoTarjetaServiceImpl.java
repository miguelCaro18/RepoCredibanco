package com.credibanco.assesment.card.service.impl;

import com.credibanco.assesment.card.model.EstadoTarjeta;
import com.credibanco.assesment.card.repository.EstadoTarjetaRepository;
import com.credibanco.assesment.card.service.EstadoTarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstadoTarjetaServiceImpl implements EstadoTarjetaService {

    @Autowired
    EstadoTarjetaRepository estadoTarjetaRepository;


    @Override
    public Optional<EstadoTarjeta> getEstadoTarjetaById(Integer id) {
        return estadoTarjetaRepository.findById(id);
    }

}
