package ar.edu.utn.parcial.futbolmanager.client.dolar;

import ar.edu.utn.parcial.futbolmanager.client.CurrencyConverterResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DolarResponse {

    @JsonProperty("casa")
    private CurrencyConverterResponse currencyConverter;
}
