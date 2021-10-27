package com.app.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

import org.hibernate.annotations.Type;


@Entity // This tells Hibernate to make a table out of this class
@Table(name = "Person")
public class Person implements Comparable<Person> {
    public interface CreateValidation {}

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @NotEmpty(groups = CreateValidation.class, message = "name may not be empty")
    @Column(nullable = false)
    private String lastName;

    @NotEmpty(groups = CreateValidation.class, message = "email may not be empty")
    @Email(message = "email must have email format")
    @Column(nullable = false)
    private String email;

    @NotEmpty(groups = CreateValidation.class, message = "telephone may not be empty")
    @Column(nullable = false)
    private String telephone;

    // for deserialisation
    public Person() {}

    public Person(String firstName, String lastName, String email, String telephone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone= telephone;
    }

    public Long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, telephone);
    }

    public String toString() {
        return this.firstName + " " + this.lastName;
    }

    public int compareTo(Person l) {
        return l.getLastName().compareTo(lastName);
    }
}