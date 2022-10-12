package com.example.testspring1.service;

import com.example.testspring1.entity.Person;
import com.example.testspring1.exceptions.PersonNotFoundException;
import com.example.testspring1.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PersonService {

    private final PersonRepo personRepo;

    @Autowired
    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public Person addPerson(Person person){
        return personRepo.save(person);
    }
    public List<Person> findAllPeople(){
        return personRepo.findAll();
    }
    public Person findPersonById(int id){
       return personRepo.findPersonById(id).orElseThrow(()-> new PersonNotFoundException("Person with "+id+" was not found!!"));

    }
    public Person updatePerson(Person person){
        return personRepo.save(person);
    }
    public void deletePerson(int id){
        personRepo.deletePersonById(id);
    }
}
