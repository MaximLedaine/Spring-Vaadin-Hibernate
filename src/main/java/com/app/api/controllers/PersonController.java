package com.app.api.controllers;

import com.app.api.entities.Person;
import com.app.api.repositories.PersonRepository;

import javax.persistence.EntityNotFoundException;
import org.springframework.validation.annotation.Validated;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonController {
    @Autowired
    private PersonRepository repository;

    public List<Person> getAll() {
        return repository.findAll();
    }

    public List<Person> getByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }

    public Person getById (Long id) throws EntityNotFoundException {
        Person person = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        return person;
    }

    public Person create(@Validated(Person.CreateValidation.class) Person newPerson) {
        Person person = repository.save(newPerson);
        return person;
    }

    public Person update (@Validated(Person.UpdateValidation.class) Person newPerson) throws EntityNotFoundException {
        Person updatedPerson = repository.findById(newPerson.getId()) //
                .map(person -> {
                    // update the user properties and save
                    person.setFirstName(newPerson.getFirstName());
                    person.setLastName(newPerson.getLastName());
                    return repository.save(person);
                }) //
                .orElseThrow(() -> new EntityNotFoundException());

        return updatedPerson;
    }

    public Person delete(Person person) throws EntityNotFoundException {
        Person dbPerson = repository.findById(person.getId())
                .orElseThrow(() -> new EntityNotFoundException());

        repository.delete(dbPerson);

        return dbPerson;
    }
}