package ar.edu.utn.parcial.futbolmanager.client.euro;

import ar.edu.utn.parcial.futbolmanager.client.CurrencyConverterResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EuroResponse {

    @JsonProperty("dolar")
    private CurrencyConverterResponse currencyConverter;

}
