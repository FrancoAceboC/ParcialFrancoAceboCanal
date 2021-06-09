package ar.edu.utn.parcial.futbolmanager.models;

import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.Set;

@Data
public class Party {

    private Long id;

    private LocalDate date;

    @OneToOne
    @JoinColumn(name = "idPerson", referencedColumnName = "ID_PERSON")
    private Manager birthdayPerson;


    private Set<Player> invitados;

}
