# My Project

This is an example project that can be used as a starting point to create your own Vaadin application with Spring Boot.
It contains all the necessary configuration and some placeholder files to get you started.

The project is a standard Maven project, so you can import it to your IDE of choice. [Read more how to set up a development environment](https://vaadin.com/docs/v14/flow/installing/installing-overview.html) for Vaadin projects (Windows, Linux, macOS).

This project was created from https://start.vaadin.com.

## Running the Application
There are two ways to run the application:
- To run from the command line, use `mvn` and open [http://localhost:8080](http://localhost:8080) in your browser.
- Another way is to to run the `Application` class directly from your IDE.

#### Intellij IDEA
- On the right side of the window, select Maven --> Plugins--> `spring-boot` --> `spring-boot:run` goal
- Optionally, you can disable tests by clicking on a `Skip Tests mode` blue button.

Clicking on the green run button will start the application.

After the application has started, you can view your it at http://localhost:8080/ in your browser.

## Project structure

File structure
```
├───frontend
  └───styles
├───src.main.java.com.app
  └───api
    └───controllers
    └───entities
    └───repositories
  └───components
  └───pages
  └───services
  └───Application.java
└───src.resources
  └───application.properties
```

