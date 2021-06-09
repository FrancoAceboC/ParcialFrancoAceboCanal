package ar.edu.utn.parcial.futbolmanager.controller;

import ar.edu.utn.parcial.futbolmanager.dto.request.CurrencyRequestDTO;
import ar.edu.utn.parcial.futbolmanager.dto.response.CurrencyResponseDTO;
import ar.edu.utn.parcial.futbolmanager.service.MarketValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/currencies")
public class CurrencyController {

    private MarketValueService MarketValueService;

    @Autowired
    public CurrencyController(MarketValueService marketValueService) {
        MarketValueService = marketValueService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CurrencyResponseDTO> addCurrency(@Valid CurrencyRequestDTO currency){

        return ResponseEntity.ok().build();
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CurrencyResponseDTO> getCurrency(@Valid CurrencyRequestDTO currency){

        return ResponseEntity.ok().build();
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CurrencyResponseDTO> getCurrencyById(@Valid CurrencyRequestDTO currency){

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CurrencyResponseDTO> deleteCurrencyById(@Valid CurrencyRequestDTO currency){

        return ResponseEntity.ok().build();
    }

}
