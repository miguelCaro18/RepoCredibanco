package com.credibanco.assesment.card.utils;

import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Component
public class UtilitiesTransaction {


    /**
     *
     * @param first Instant con la primera fecha
     * @param last Instant con la segunda fecha a comparar
     * @param maxSeconds Maximos segundos para validar el tiempo
     * @return Regresa un boolean con True si los segundos que han pasado son menos que los establecidos en max.
     */
    public static boolean  isLessThanNSeconds(Instant first, Instant last, int maxSeconds){
        Duration diference = Duration.between(first, last);
        long seconds = diference.getSeconds();
        return seconds<maxSeconds;

    }

}
