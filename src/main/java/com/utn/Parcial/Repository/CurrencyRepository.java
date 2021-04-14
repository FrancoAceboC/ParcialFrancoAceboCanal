package com.utn.Parcial.Repository;

import com.utn.Parcial.Model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
}
