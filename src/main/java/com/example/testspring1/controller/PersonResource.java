package com.example.testspring1.controller;

import com.example.testspring1.entity.Person;
import com.example.testspring1.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Person")
public class PersonResource {

    private PersonService personService;

    public PersonResource(PersonService personService) {
        this.personService = personService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAllPerson(){
        List<Person> people =personService.findAllPeople();
        return new ResponseEntity<>(people, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") int id){
        Person person =personService.findPersonById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Person> addPerson(@RequestBody Person person){
        Person newPerson=personService.addPerson(person);
        return new ResponseEntity<>(newPerson,HttpStatus.CREATED);
    }
    @PutMapping ("/update")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person){
        Person updatePerson=personService.updatePerson(person);
        return new ResponseEntity<>(updatePerson,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable("id") int id){
         personService.deletePerson(id);
        return new ResponseEntity<String>("supprimer!!!",HttpStatus.OK);
    }











}
