package com.utn.Parcial.Service;

import com.utn.Parcial.Exceptions.AlreadyExistException;
import com.utn.Parcial.Exceptions.NotFoundException;
import com.utn.Parcial.Model.Manager;
import com.utn.Parcial.Model.Person;
import com.utn.Parcial.Model.Player;
import com.utn.Parcial.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void addPerson(Person person){
        if (this.personRepository.existsById(person.getId())){
            throw new AlreadyExistException("Person already exist");
        }else{
            personRepository.save(person);
        }
    }

    public List<Person> getAll(){
        return personRepository.findAll();
    }

    public Person getPersonById(Integer idPerson){
        return personRepository.findById(idPerson).orElseThrow(() -> new NotFoundException("Person not found"));
    }

    public void deletePerson(Integer idPerson){
        if (this.personRepository.existsById(idPerson)){

            this.personRepository.deleteById(idPerson);
        }else {
            throw new NotFoundException("Person doesn't exist");
        }
    }

    public void playerByManager(Integer idManager, Integer idPlayer){
        Person managerOptional = this.getPersonById(idManager);
        if (managerOptional != null){
            Manager manager = (Manager) managerOptional;
            Optional<Player>player = manager.findPlayer(idPlayer);
            if (player.isPresent()){
                Player playerOptional = player.get();
                manager.refreshWeight(playerOptional.getCurrency().getAmount());
                manager.refreshTotalAmount(playerOptional.getCurrency().getAmount(),
                                            playerOptional.getCurrency().getCurrency());
                this.personRepository.save(manager);
            }else{
                throw new NotFoundException("Player not found by the manager");
            }
        }else {
            throw new NotFoundException("Manager cannot exists");
        }
    }
}
