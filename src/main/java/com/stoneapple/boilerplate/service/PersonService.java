package com.stoneapple.boilerplate.service;

import com.stoneapple.boilerplate.model.Person;

import java.util.List;

public interface PersonService {

    void savePerson(Person person);

    List<Person> findAllPerson();

    Person findByEmail(String email);

}
