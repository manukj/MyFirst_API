package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.UUID;


@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person)
    {
        personService.addPerson(person);

    }
    @GetMapping
    public List<Person> getAllPeople()
    {
        return personService.getAllPeople();
    }


    @GetMapping(path ="{id}" )
    public Person getPersonById(@PathVariable("id") UUID id)
    {
        return personService.getPersonById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public int deleteByPersonById(@PathVariable("id") UUID uuid)
    {
        return personService.deletePerson(uuid);
    }

    @PutMapping(path = "{id}")
    public int updatePersonById(@PathVariable("id") UUID uuid, @RequestBody Person person)
    {
        return personService.updatePerson(uuid,person);
    }
}
