package ar.edu.utn.parcial.futbolmanager.dto.request;

import ar.edu.utn.parcial.futbolmanager.models.enums.Currency;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class CurrencyRequestDTO {

    @NotBlank
    private Currency currency;

    @NotNull
    @Digits(integer=10, fraction=0)
    private BigDecimal amount;

}
