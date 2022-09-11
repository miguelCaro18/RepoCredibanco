package com.credibanco.assesment.card.utils;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class UtilitiesCard {




    public static String getValidateNumberTo999(){
        Integer[] numberArray = randomList();
        StringBuilder strValidate = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            long timeMilli = (long)(new Date().getTime()*Math.random());
            String firstDigit = String.valueOf(timeMilli).substring(0,1);
            strValidate.append(numberArray[Integer.valueOf(firstDigit)]);
        }
        return strValidate.toString();
    }

    /**
     *  metodo que devuelve un string(caracteres numéricos) con 3 posiciones  formando un número entre 1 y 100 (excluyente)
     *
     * @return string de 3 posiciones con caracteres numéricos
     */
    public static String getValidateNumberTo099(){
        Integer[] numberArray = randomList();
        StringBuilder strValidate;
        do{
            strValidate = new StringBuilder("0");
            for (int i = 0; i < 2; i++) {
                long timeMilli = (long)(new Date().getTime()*Math.random());
                String firstDigit = String.valueOf(Math.abs(timeMilli%10));
                strValidate.append(numberArray[Integer.valueOf(firstDigit)]);
            }
        }while(strValidate.toString().equals("000") || strValidate.toString().equals("001"));
        return strValidate.toString();
    }

    public static String enmascararPAN(String originalPAN, int numberInit, int numberFinish){
        int nMask=originalPAN.length()-numberInit-numberInit;
        String stringPANReturn = "*".repeat(nMask);
        return String.format("%s%s%s",originalPAN.substring(0,numberInit),stringPANReturn,originalPAN.substring(originalPAN.length()-numberFinish));
    }
    /**
     * Genera una lista aleatoria
     * @return lista de 10 posiciones del 0 al 9 en orden aleatorio.
     */
    private static Integer[] randomList(){
        Integer[] numberArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        List<Integer> numberList = Arrays.asList(numberArray);
        Collections.shuffle(numberList);
        numberList.toArray(numberArray);
        return numberArray;
    }
}
