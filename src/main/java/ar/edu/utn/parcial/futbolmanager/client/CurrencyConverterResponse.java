package ar.edu.utn.parcial.futbolmanager.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CurrencyConverterResponse {

    @JsonProperty("nombre")
    private String name;

    @JsonProperty("compra")
    private Double buys;

    @JsonProperty("venta")
    private Double sale;

}
