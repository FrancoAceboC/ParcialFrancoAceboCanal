package com.utn.Parcial.Repository;

import com.utn.Parcial.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface PersonRepository extends JpaRepository<Person, Integer> {
    
}
