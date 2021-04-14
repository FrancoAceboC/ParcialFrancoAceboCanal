package com.utn.Parcial.Controller;

import com.utn.Parcial.Model.Currency;
import com.utn.Parcial.Model.Person;
import com.utn.Parcial.Service.CurrencyService;
import com.utn.Parcial.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/currency")
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    @GetMapping("")
    public List<Currency> getAll(){
        return currencyService.getAll();
    }

    @GetMapping("/{id}")
    public Currency getCurrencyById(@PathVariable Integer idCurrency){
        return currencyService.getCurrencyById(idCurrency);
    }

    @PostMapping
    public void addCurrency(@RequestBody Currency currency){
        currencyService.addCurrency(currency);
    }

    @DeleteMapping("/{id}")
    public void deleteCurrency(@PathVariable Integer idCurrency){
        this.currencyService.deleteCurrency(idCurrency);
    }
}
