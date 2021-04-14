package com.utn.Parcial.Service;

import com.utn.Parcial.Exceptions.NotFoundException;
import com.utn.Parcial.Model.Person;
import com.utn.Parcial.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void addPerson(Person person){
        personRepository.save(person);
    }

    public List<Person> getAll(){
        return personRepository.findAll();
    }

    public Person getPersonById(Integer idPerson){
        return personRepository.findById(idPerson).orElseThrow(() -> new NotFoundException("Person not found"));
    }

//    public void addPlayerToPerson(Integer idPerson, Integer idPlayer) {
//        Person person = this.getPersonById(idPerson);
//    }

    public void deletePerson(Integer idPerson){
        this.personRepository.deleteById(idPerson);
    }
}
