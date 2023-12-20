package dev.carlosezpereira.restwithspringbootandjavaerudio.mapper.custom;

import dev.carlosezpereira.restwithspringbootandjavaerudio.data.vo.v2.PersonVOv2;
import dev.carlosezpereira.restwithspringbootandjavaerudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {
    public PersonVOv2 convertEntityToVO(Person person){
        PersonVOv2 vo = new PersonVOv2();
        vo.setId(person.getId());
        vo.setAddress(person.getAddress());
        vo.setGender(person.getGender());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setBirthDay(new Date());
        return vo;
    }
    public Person convertVOToEntity(PersonVOv2 person){
        Person entity = new Person();
        entity.setId(person.getId());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        return entity;
    }
}
