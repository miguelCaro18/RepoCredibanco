package com.credibanco.assesment.card.validatorEnum;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * ESTE CODIGO FUE EXTRAIDO DE STACKOVERFLOW
 */
public class EnumValidatorImpl implements ConstraintValidator<EnumValidator, String> {

    private List<String> valueList;

    @Override
    public void initialize(EnumValidator constraintAnnotation) {
        valueList = new ArrayList<String>();
        for(String val : constraintAnnotation.acceptedValues()) {
            valueList.add(val.toUpperCase());
        }
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return valueList.contains(value.toUpperCase());
    }

}