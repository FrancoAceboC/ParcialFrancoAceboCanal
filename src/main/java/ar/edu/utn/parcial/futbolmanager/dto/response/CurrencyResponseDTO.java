package ar.edu.utn.parcial.futbolmanager.dto.response;

import ar.edu.utn.parcial.futbolmanager.models.enums.Currency;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CurrencyResponseDTO {

    private Long id;

    private Currency currency;

    private BigDecimal amount;

}
