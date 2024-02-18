package dev.carlosezpereira.restwithspringbootandjavaerudio.controller;

import dev.carlosezpereira.restwithspringbootandjavaerudio.data.vo.v1.PersonVO;
import dev.carlosezpereira.restwithspringbootandjavaerudio.data.vo.v2.PersonVOv2;
import dev.carlosezpereira.restwithspringbootandjavaerudio.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import dev.carlosezpereira.restwithspringbootandjavaerudio.util.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public PersonVO findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

    @GetMapping(value = "/all",
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public List<PersonVO> findAll() {
        return service.findAll();
    }

    @PostMapping(value = "/",
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public PersonVO create(@RequestBody PersonVO person) {
        return service.create(person);
    }

    @PostMapping(value = "/v2",
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public PersonVOv2 createV2(@RequestBody PersonVOv2 person) {
        return service.createV2(person);
    }

    @PatchMapping(value = "/",
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public PersonVO updateOnePerson(@RequestBody PersonVO person) {
        return service.updateOnePerson(person);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
    }
}
