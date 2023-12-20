package dev.carlosezpereira.restwithspringbootandjavaerudio.services;

import dev.carlosezpereira.restwithspringbootandjavaerudio.data.vo.v1.PersonVO;
import dev.carlosezpereira.restwithspringbootandjavaerudio.data.vo.v2.PersonVOv2;
import dev.carlosezpereira.restwithspringbootandjavaerudio.exceptions.ResourceNotFoundException;
import dev.carlosezpereira.restwithspringbootandjavaerudio.mapper.DozerMapper;
import dev.carlosezpereira.restwithspringbootandjavaerudio.mapper.custom.PersonMapper;
import dev.carlosezpereira.restwithspringbootandjavaerudio.model.Person;
import dev.carlosezpereira.restwithspringbootandjavaerudio.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;
    @Autowired
    PersonMapper personMapper;

    public PersonVO findById(Long id){
        logger.info("Finding one person.");
        var entity = repository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        return DozerMapper.parseObject(entity,PersonVO.class);
    }

    public List<PersonVO> findAll(){
        logger.info("Finding all persons!");
        return DozerMapper.parseListObjects(repository.findAll(),PersonVO.class);
    }
    public PersonVO create(PersonVO person){
        logger.info("Create a person!");
        var entity = DozerMapper.parseObject(person,Person.class);
        return DozerMapper.parseObject(repository.save(entity),PersonVO.class);
    }
    public PersonVOv2 createV2(PersonVOv2 person){
        logger.info("Create a person!");
        var entity = DozerMapper.parseObject(person,Person.class);
        return personMapper.convertEntityToVO(repository.save(entity));
    }
    public PersonVO updateOnePerson(PersonVO  person){
        logger.info("Updating a person!");

        var entry = DozerMapper.parseObject(person,Person.class);
        var entity = repository.findById(entry.getId())
                        .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID!"));

        entity.setFirstName(entry.getFirstName());
        entity.setLastName(entry.getLastName());
        entity.setAddress(entry.getAddress());
        entity.setGender(entry.getGender());

        return DozerMapper.parseObject(repository.save(entity),PersonVO.class);
    }
    public void delete(Long id){
        logger.info("Deleting a person!");
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID!"));
        repository.delete(entity);
    }
}
