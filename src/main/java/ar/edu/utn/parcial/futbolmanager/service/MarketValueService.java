package ar.edu.utn.parcial.futbolmanager.service;

import ar.edu.utn.parcial.futbolmanager.repository.MarketValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketValueService {

    private MarketValueRepository marketValueRepository;

    @Autowired
    public MarketValueService(MarketValueRepository marketValueRepository) {
        this.marketValueRepository = marketValueRepository;
    }

    //SAVE


    //GETALL

    //GET BY Id






}
