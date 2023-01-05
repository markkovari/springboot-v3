package com.example.demov3.service;

import com.example.demov3.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> findAll();
    Person add(Person toSave);
}
