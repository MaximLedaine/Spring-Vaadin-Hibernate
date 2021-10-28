package com.app.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

@Tag("div")
@CssImport("./styles/components/forecast.css")
public class Forecast extends Component {
    static final long serialVersionUID = 399870393;
    private boolean uncertain = false;
    private boolean neutral = true;
    private boolean increasing = false;
    private boolean decreasing = false;
    private String message;
    private H2 messageField;
    private String subMessage;
    private H4 subMessageField;
    private Icon uncertainIcon = new Icon(VaadinIcon.LINE_H);
    private Icon neutralIcon = new Icon(VaadinIcon.ARROWS_LONG_RIGHT);
    private Icon increasingIcon = new Icon(VaadinIcon.TRENDING_UP);
    private Icon decreasingIcon = new Icon(VaadinIcon.TRENDIND_DOWN);
    private Icon icon;
    VerticalLayout layout = new VerticalLayout();

    public Forecast () {
        messageField = new H2(message);
        messageField.addClassName("forecast-title");
        subMessageField = new H4(subMessage);
        subMessageField.addClassName("forecast-title");

        String size = "120px";
        uncertainIcon.setSize(size);
        uncertainIcon.setClassName("neutral");
        neutralIcon.setSize(size);
        neutralIcon.setClassName("neutral");
        increasingIcon.setSize(size);
        increasingIcon.setClassName("red");
        decreasingIcon.setSize(size);
        decreasingIcon.setClassName("green");

        icon = neutralIcon;

        layout.add(icon);
        layout.add(messageField);
        layout.add(subMessageField);
        layout.addClassName("forecast");
        this.setMessage("Neutral");
        getElement().appendChild(layout.getElement());
    }

    public void setNeutral() {
        this.neutral = true;
        this.uncertain = false;
        this.increasing = false;
        this.decreasing = false;
        this.setMessage("Neutral");
        setIcon(neutralIcon);
    }

    public boolean isNeutral() {
        return this.neutral;
    }

    public void setIncreasing() {
        this.uncertain = false;
        this.neutral = false;
        this.increasing = true;
        this.decreasing = false;
        this.setMessage("Increasing");
        setIcon(increasingIcon);
    }

    public boolean isIncreasing() {
        return this.increasing;
    }

    public void setDecreasing() {
        this.uncertain = false;
        this.neutral = false;
        this.increasing = false;
        this.decreasing = true;
        this.setMessage("Decreasing");
        setIcon(decreasingIcon);
    }

    public boolean isDecreasing() {
        return this.decreasing;
    }

    public boolean isUncertain() {
        return this.uncertain;
    }

    public void setUncertain() {
        this.uncertain = true;
        this.neutral = false;
        this.increasing = false;
        this.decreasing = false;
        this.setMessage("Uncertain");
        setIcon(uncertainIcon);
    }


    public void setMessage (String message) {
        this.message = message;
        this.messageField.setText(message);
    }

    public String getMessage() {
        return this.message;
    }
    public void setSubMessage (String message) {
        this.subMessage = message;
        this.subMessageField.setText(message);
    }

    public String getSubMessage() {
        return this.subMessage;
    }

    private void setIcon(Icon newIcon) {
        layout.replace(icon, newIcon);
        this.icon = newIcon;
    }
}
