package dev.carlosezpereira.restwithspringbootandjavaerudio.service;

import dev.carlosezpereira.restwithspringbootandjavaerudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(String id){
        logger.info("Finding one person.");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Carlos");
        person.setLastName("Pereira");
        person.setAddress("Rodeio - SC");
        person.setGender("Masculino");
        return person;
    }

    public List<Person> findAll(){
        logger.info("Finding all persons!");

        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++){
            Person mockedPerson = mockPerson(i);
            persons.add(mockedPerson);
        }
        return persons;
    }
    public Person create(Person person){
        logger.info("Create a person!");
        return person;
    }
    public Person updateOnePerson(Person person){
        logger.info("Updating a person!");
        return person;
    }
    public Person delete(String id){
        logger.info("Deleting a person!");
        return findById(id);
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("First Name " + i);
        person.setLastName("Last Name " + i);
        person.setAddress("Some address " + i);
        person.setGender("Some gender " + i);
        return person;
    }
}
