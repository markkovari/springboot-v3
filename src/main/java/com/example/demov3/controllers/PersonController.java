package com.example.demov3.controllers;

import com.example.demov3.models.Person;
import com.example.demov3.services.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = {"/"})
    public ResponseEntity<List<Person>> getAll() {
        return ResponseEntity.ok(personService.findAll());
    }

    @PostMapping(path = {"/"})
    public ResponseEntity<Person> add(@RequestBody Person person) {
        return ResponseEntity.ok(personService.add(person));
    }
}
