package com.utn.Parcial.Controller;

import com.utn.Parcial.Model.Person;
import com.utn.Parcial.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("")
    public List<Person>getAll(){
        return personService.getAll();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Integer idPerson){
        return personService.getPersonById(idPerson);
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

//    @PutMapping
//    public void addPlayerToPerson()

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Integer idPerson){
        this.personService.deletePerson(idPerson);
    }
}
