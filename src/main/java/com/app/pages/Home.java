package com.app.pages;

import com.app.MainView;

import com.vaadin.flow.component.grid.Grid;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.AppNavLayout;
import com.app.components.MyNotification;
import com.app.api.controllers.PersonController;
import com.app.api.entities.Note;
import com.app.api.entities.Person;


@Route(value = "", layout = MainView.class)
@PageTitle("Basic Application")
public class Home extends AppNavLayout {
    static final long serialVersionUID = 9327986;
    private PersonController personController;
    Grid<Person> grid = new Grid<>(Person.class);
    private List<Person> persons = new ArrayList<>();

    @Autowired
    public Home(PersonController controller) {
        this.personController = controller;
        this.setPersons();
        this.setGrid((persons));

        VerticalLayout main = new VerticalLayout();

        main.add(new H1("Home page"));

        main.add(new Button("Notification message", e -> MyNotification.set("Hello, alien")));

        main.add(new Button("Create new Person", e -> this.createPerson()));

        main.add(this.grid);
        setContent(main);
    }
    private void setPersons() {
        try {
            this.persons =  personController.getAll();
        }
        catch(Exception e) {
            MyNotification.set(e.getMessage());
        }
    }

    private void createPerson () {
        List<Note> notes = new ArrayList<>();
        Note note = new Note("This is a title", "This is a description");
        notes.add(note);

        Person person = new Person("Mick", "Jagger", "mick.jagger@outlook.com", "047645891", notes);

        this.personController.create(person);
        
        this.setPersons();
        this.grid.setItems(persons);
    }

    private void setGrid(List<Person> data) {
        this.grid.setItems(data);

        this.grid.removeColumnByKey("id");
        // The Grid<>(Person.class) sorts the properties and in order to
        // reorder the properties we use the 'setColumns' method.
        this.grid.setColumns("firstName", "lastName", "email", "telephone");
    }
}
