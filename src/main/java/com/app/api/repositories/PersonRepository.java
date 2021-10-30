package com.app.api.repositories;
import com.app.api.entities.Note;
import com.app.api.entities.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;



// This will be AUTO IMPLEMENTED by Spring into a Bean called PersonRepository
// CRUD refers Create, Read, Update, Delete
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByLastName(String lastName);
    List<Person> findByNotes(Note note);
    List<Person> findByEmailAndLastName(String emailAddress, String lastname);
    List<Person> findByEmailOrLastName(String emailAddress, String lastname);

    // All possible query filters
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
}