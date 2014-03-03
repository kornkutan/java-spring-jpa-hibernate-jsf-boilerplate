package com.stoneapple.boilerplate.web.controller;

import java.util.List;

import com.stoneapple.boilerplate.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.stoneapple.boilerplate.model.Person;

@Component
@ViewScoped
@ManagedBean
public class PersonController {

    @Autowired
    private PersonService personService;

    @ManagedProperty(value = "#{person}")
    private Person person;

    public PersonController() {
        person = new Person();
    }

    public String createPerson() {

        Person person = new Person();
        person.setName(this.person.getName());
        person.setEmail(this.person.getEmail());

        personService.savePerson(person);
        this.person = new Person();

        FacesMessage msg = new FacesMessage();
        msg.setDetail("The person has been added.");
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg);

        return "index";
    }

    public List<Person> getFetchPerson() {
        return personService.findAllPerson();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
