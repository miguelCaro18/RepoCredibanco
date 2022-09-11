package com.credibanco.assesment.card.repository;

import com.credibanco.assesment.card.model.Transaccion;
import com.credibanco.assesment.card.model.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransaccionRepository extends JpaRepository<Transaccion, Integer> {

     List<Transaccion> getTransaccionByPanTarjetaAndReferencia(Tarjeta pan_tarjeta,String referencia);
}