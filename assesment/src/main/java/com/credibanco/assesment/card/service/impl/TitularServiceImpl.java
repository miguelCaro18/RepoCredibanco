package com.credibanco.assesment.card.service.impl;

import com.credibanco.assesment.card.model.Titular;
import com.credibanco.assesment.card.repository.TitularRepository;
import com.credibanco.assesment.card.service.TitularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TitularServiceImpl implements TitularService {

    @Autowired
    TitularRepository titularRepository;

    @Override
    public Titular createTitular(Titular t) {
        return  titularRepository.save(t);
    }
}
