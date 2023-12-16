package dev.carlosezpereira.restwithspringbootandjavaerudio.controller;

import dev.carlosezpereira.restwithspringbootandjavaerudio.model.Person;
import dev.carlosezpereira.restwithspringbootandjavaerudio.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @RequestMapping(value = "/{id}",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable(value = "id") String id){
        return service.findById(id);
    }

    @RequestMapping(value = "/all",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll(){
        return service.findAll();
    }

    @RequestMapping(value = "/create",
                    method = RequestMethod.POST,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person){
        return service.create(person);
    }

    @RequestMapping(value = "/update",
                    method = RequestMethod.PUT,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Person updateOnePerson(@RequestBody Person person){
        return service.updateOnePerson(person);
    }

    @RequestMapping(value = "/delete/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person updateOnePerson(@PathVariable(value = "id") String id){
        return service.delete(id);
    }
}
