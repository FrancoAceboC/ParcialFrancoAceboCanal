package ar.edu.utn.parcial.futbolmanager.models;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Manager extends Person {

    @Column(name = "TOTAL_AMOUNT")
    private Integer totalAmount;

    @Column(name = "AMOUNT_OF_THE_VAULT")
    private Double vaultWeight;

    @OneToMany(mappedBy = "manager")
    private List<Player> listPlayer;


}
