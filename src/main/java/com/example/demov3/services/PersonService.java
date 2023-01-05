package com.example.demov3.services;

import com.example.demov3.models.Person;

import java.util.List;

public interface PersonService {
    List<Person> findAll();
    Person add(Person toSave);
}
