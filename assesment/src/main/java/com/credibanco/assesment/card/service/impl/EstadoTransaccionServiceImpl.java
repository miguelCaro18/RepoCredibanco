package com.credibanco.assesment.card.service.impl;

import com.credibanco.assesment.card.model.EstadoTarjeta;
import com.credibanco.assesment.card.model.EstadoTransaccion;
import com.credibanco.assesment.card.repository.EstadoTarjetaRepository;
import com.credibanco.assesment.card.repository.EstadoTransaccionRepository;
import com.credibanco.assesment.card.service.EstadoTarjetaService;
import com.credibanco.assesment.card.service.EstadoTransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstadoTransaccionServiceImpl implements EstadoTransaccionService {

    @Autowired
    EstadoTransaccionRepository estadoTransaccionRepository;


    @Override
    public Optional<EstadoTransaccion> getEstadoTransaccionById(Integer id) {
        return estadoTransaccionRepository.findById(id);
    }

}
