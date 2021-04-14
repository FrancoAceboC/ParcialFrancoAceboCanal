package com.utn.Parcial.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CURRENCY")
    private Integer idCurrency;

    @NotNull(message = "The field currency is required")
    @Column(name = "CURRENCY")
    private String currency;

    @NotNull(message = "The field amount is required")
    @Column(name = "AMOUNT")
    private float amount;

    @OneToOne(mappedBy = "currency")
    private Player player;
}
