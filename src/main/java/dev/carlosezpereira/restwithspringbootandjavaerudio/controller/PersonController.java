package dev.carlosezpereira.restwithspringbootandjavaerudio.controller;

import dev.carlosezpereira.restwithspringbootandjavaerudio.model.Person;
import dev.carlosezpereira.restwithspringbootandjavaerudio.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

    @GetMapping(value = "/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll() {
        return service.findAll();
    }

    @PostMapping(value = "/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person) {
        return service.create(person);
    }

    @PatchMapping(value = "/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person updateOnePerson(@RequestBody Person person) {
        return service.updateOnePerson(person);
    }
    @DeleteMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable(value = "id") Long id){
        service.delete(id);
    }
}
