package com.app.pages;

import com.app.MainView;
import java.util.ArrayList;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
// https://vaadin.com/directory/component/crud-ui-add-on
import org.vaadin.crudui.crud.CrudOperation;
import org.vaadin.crudui.crud.impl.GridCrud;
import org.vaadin.crudui.layout.impl.HorizontalSplitCrudLayout;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.AppNavLayout;
import com.app.components.MyNotification;
import com.app.components.MyNotification;
import com.app.api.controllers.PersonController;
import com.app.api.entities.Person;


@Route(value = "", layout = MainView.class)
@PageTitle("Basic Application")
public class Home extends AppNavLayout {
    static final long serialVersionUID = 9327986;

    private PersonController personController;

    @Autowired
    public Home(PersonController controller) {
        this.personController = controller;

        List<Person> persons = controller.getAll();
        System.out.println(persons);

        VerticalLayout main = new VerticalLayout();


        main.add(new H1("Header text"), new Paragraph("Main content"));

        main.add(new Button("Click me", e -> MyNotification.set("Hello, Spring+Vaadin user!")));

        setContent(main);
    }
}
