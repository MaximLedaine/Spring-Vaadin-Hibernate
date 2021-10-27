package com.app.pages;

import com.app.MainView;
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
import com.app.AppNavLayout;

@Route(value = "page", layout = MainView.class)
@PageTitle("Page")
public class Page extends AppNavLayout {

    public Page() {
        VerticalLayout main = new VerticalLayout();

        main.add(new H1("Other page"), new Paragraph("Page content"));
        setContent(main);
    }
}
