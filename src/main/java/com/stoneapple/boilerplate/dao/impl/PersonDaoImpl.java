package com.stoneapple.boilerplate.dao.impl;

import javax.persistence.TypedQuery;

import com.stoneapple.boilerplate.dao.PersonDao;
import com.stoneapple.boilerplate.model.Person;

import org.springframework.stereotype.Repository;

@Repository("personDao")
public class PersonDaoImpl extends GenericDaoImpl<Person> implements PersonDao {

    @Override
    public Person findByName(String name) {
        TypedQuery<Person> query = entityManager.createNamedQuery("Person.findByName", Person.class);
        return query.setParameter("name", name).getSingleResult();
    }

    @Override
    public Person findByEmail(String email) {
        TypedQuery<Person> query = entityManager.createNamedQuery("Person.findByEmail", Person.class);
        return query.setParameter("email", email).getSingleResult();
    }

}
