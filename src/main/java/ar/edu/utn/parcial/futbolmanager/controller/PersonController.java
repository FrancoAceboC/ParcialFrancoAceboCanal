package ar.edu.utn.parcial.futbolmanager.controller;

import ar.edu.utn.parcial.futbolmanager.models.Person;
import ar.edu.utn.parcial.futbolmanager.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{personId}")
    public Person getPersonById(@PathVariable Long personId){
        return this.personService.getById(personId);
    }

    @GetMapping("/")
    public List<Person> getAll(@RequestParam(required = false) String filtro){ //parametro opcional
        return personService.getAll(filtro);
    }


}
