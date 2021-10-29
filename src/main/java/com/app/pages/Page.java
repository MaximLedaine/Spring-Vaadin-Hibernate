package com.app.pages;

import com.app.MainView;
import com.app.components.Forecast;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.app.AppNavLayout;

@Route(value = "page", layout = MainView.class)
@PageTitle("Page")
public class Page extends AppNavLayout {
    Forecast forecast;

    public Page() {
        VerticalLayout main = new VerticalLayout();
        this.forecast = new Forecast();

        main.add(new H1("Other page"));

        main.add(new Button("Change forecast", e -> {
            if (this.forecast.isIncreasing()) {
                this.forecast.setDecreasing();
            } else {
                this.forecast.setIncreasing();
            }
        }));

        main.add(this.forecast);

        setContent(main);
    }
}
