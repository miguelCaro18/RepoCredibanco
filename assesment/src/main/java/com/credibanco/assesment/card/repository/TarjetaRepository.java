package com.credibanco.assesment.card.repository;

import com.credibanco.assesment.card.model.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarjetaRepository extends JpaRepository<Tarjeta, String> {
}