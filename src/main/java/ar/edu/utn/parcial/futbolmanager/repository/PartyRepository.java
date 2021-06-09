package ar.edu.utn.parcial.futbolmanager.repository;

import ar.edu.utn.parcial.futbolmanager.models.Party;
import ar.edu.utn.parcial.futbolmanager.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartyRepository extends JpaRepository<Party, Long>, JpaSpecificationExecutor<Party> {
    Optional<Party> findByBirthdayPerson(Person birthdayPerson);
}
