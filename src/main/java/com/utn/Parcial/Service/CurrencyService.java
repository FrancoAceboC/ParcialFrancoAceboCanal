package com.utn.Parcial.Service;

import com.utn.Parcial.Model.Currency;

import com.utn.Parcial.Repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public void addCurrency(Currency currency){
        currencyRepository.save(currency);
    }

    public List<Currency> getAll(){
        return currencyRepository.findAll();
    }

    public Currency getCurrencyById(Integer idCurrency){
        return currencyRepository.findById(idCurrency).orElseThrow(RuntimeException::new);
    }

    public void deleteCurrency(Integer idCurrency){
        this.currencyRepository.deleteById(idCurrency);
    }
}
