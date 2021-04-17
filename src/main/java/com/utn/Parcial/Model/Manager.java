package com.utn.Parcial.Model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@JsonTypeName("manager")
@NoArgsConstructor
@Entity()
public class Manager extends Person{


    @NotNull(message = "The field vault weight is required")
    @Column(name = "VAULT_WEIGHT")
    private float vaultWeight;

    @NotNull(message = "The field total amount is required")
    @Column(name = "TOTAL_AMOUNT")
    private float totalAmount;

    @OneToMany(mappedBy = "manager")
    private List<Player> players = new ArrayList<>();

//    public float getTotalAmount() {
//        return players.stream()
//                .map(Player::getCurrency)
//                .reduce(0, float::sum);
//    }

}
