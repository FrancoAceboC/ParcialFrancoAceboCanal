package ar.edu.utn.parcial.futbolmanager.models;

import ar.edu.utn.parcial.futbolmanager.models.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MARKET_VALUES")
public class MarketValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CURRENCY")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Column(name = "AMOUNT")
    private Integer amount;

    @OneToOne
    @JoinColumn(name="ID_PERSON", referencedColumnName = "ID_PERSON",nullable=false)
    private Player player;

}
