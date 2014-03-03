package com.stoneapple.boilerplate.dao;

import com.stoneapple.boilerplate.model.Person;

public interface PersonDao extends GenericDao<Person> {

    Person findByName(String name);

    Person findByEmail(String email);

}
