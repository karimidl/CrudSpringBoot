package com.example.testspring1.repository;

import com.example.testspring1.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepo extends JpaRepository<Person,Integer> {
    void deletePersonById(int id);

    Optional<Person> findPersonById(int id);
}
