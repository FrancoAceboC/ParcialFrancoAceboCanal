package ar.edu.utn.parcial.futbolmanager.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Player extends Person{

    @NotNull
    @Column(name = "WEIGHT")
    private Double weight;

    @NotNull
    @Column(name = "HEIGHT")
    private Double height;

    @Column(name = "GOALS")
    private Integer goals;

    @Column(name = "MINUTES_PLAYED")
    private Double minutesPlayed;

    @NotNull
    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @OneToOne
    @JoinColumn(name="ID_MARKET_VALUE", referencedColumnName = "ID",nullable=false)
    public MarketValue marketValue;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="ID_PLAYER", insertable = false,updatable = false, referencedColumnName = "ID",nullable=false)
    private Manager manager;
}
