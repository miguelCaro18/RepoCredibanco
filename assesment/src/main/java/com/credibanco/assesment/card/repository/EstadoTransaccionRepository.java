package com.credibanco.assesment.card.repository;

import com.credibanco.assesment.card.model.EstadoTransaccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoTransaccionRepository extends JpaRepository<EstadoTransaccion, Integer> {
}