package com.utn.Parcial.Model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@JsonTypeName("player")
@Entity()
@AllArgsConstructor
@NoArgsConstructor
public class Player extends Person{


    @NotNull(message = "The field weight is required")
    private float weight;

    @NotNull(message = "The field height is required")
    @Column(name = "HEIGHT")
    private float height;

    @NotNull(message = "The field goals is required")
    @Column(name = "GOALS")
    private Integer goals;

    @NotNull(message = "The field time played is required")
    @Column(name = "TIME_PLAYED")
    private Integer timePlayed;

    @NotNull(message = "The field date of born is required")
    @Column(name = "DATE_OF_BORN")
    private Date dateOfBorn;

    @OneToOne
    @JoinColumn(name = "CURRENCY_ID", referencedColumnName = "ID_CURRENCY")
    private Currency currency;

    @ManyToOne
    @JoinColumn(name = "MANAGER_ID", referencedColumnName = "ID_PLAYER")
    private Manager manager;

}
