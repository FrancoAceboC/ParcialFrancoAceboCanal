package ar.edu.utn.parcial.futbolmanager.service;

import ar.edu.utn.parcial.futbolmanager.exception.NotFoundException;
import ar.edu.utn.parcial.futbolmanager.models.Person;
import ar.edu.utn.parcial.futbolmanager.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void add(Person person){
        this.personRepository.save(person);
    }

    public Person getById(Long id){

        return this.personRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Manager Not Found"));
    }
}
