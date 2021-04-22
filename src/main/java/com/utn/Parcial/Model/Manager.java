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
import java.util.Optional;

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

    public void refreshWeight(float weight){
        this.vaultWeight = this.vaultWeight + weight;
    }

    public void refreshTotalAmount(float amount, String typeCurrency){

        this.totalAmount = typeCurrency.equals(TypeCurrency.EU) ? this.totalAmount + amount * 200 :
                typeCurrency.equals(TypeCurrency.USD) ? this.totalAmount + amount * 160 :
                        this.totalAmount + amount;
    }

    public Optional<Player>findPlayer(Integer id){
        return this.players.stream().filter(p -> p.getId() == id).findAny();
    }
}
