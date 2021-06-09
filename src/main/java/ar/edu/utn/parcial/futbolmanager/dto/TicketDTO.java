package ar.edu.utn.parcial.futbolmanager.dto;

import ar.edu.utn.parcial.futbolmanager.models.enums.Currency;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class TicketDTO {

    private String fullName;

    private Currency currency;

    private String amount;

}
