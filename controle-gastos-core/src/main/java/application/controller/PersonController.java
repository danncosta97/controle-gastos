package application.controller;

import java.util.List;

import application.service.PersonService;
import application.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/people")
    public ResponseEntity<List<Person>> getAllPeople() {
        List<Person> people = personService.findAll();
        return new ResponseEntity<>(people, HttpStatus.OK);
    }
}
