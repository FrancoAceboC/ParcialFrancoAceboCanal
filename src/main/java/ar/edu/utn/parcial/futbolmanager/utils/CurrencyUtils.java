package ar.edu.utn.parcial.futbolmanager.utils;

import ar.edu.utn.parcial.futbolmanager.exception.NotFoundException;
import ar.edu.utn.parcial.futbolmanager.models.enums.Currency;

import java.math.BigDecimal;

public class CurrencyUtils {

    private static final BigDecimal DOLLAR_TO_PESOS = BigDecimal.valueOf(150.5);
    private static final BigDecimal EURO_TO_PESOS = BigDecimal.valueOf(200.8);


    public static BigDecimal convertToPesos(Currency typeCurrency, BigDecimal amount) throws NotFoundException {

        final BigDecimal totalAmountPesos;

        if(Currency.USD.equals(typeCurrency)){
            totalAmountPesos = amount.multiply(DOLLAR_TO_PESOS);
        }else if(Currency.EUR.equals(typeCurrency)){
            totalAmountPesos = amount.multiply(EURO_TO_PESOS);
        }else{
            throw new NotFoundException("Type Currency Invalid");
        }

        return totalAmountPesos;
    }

}
