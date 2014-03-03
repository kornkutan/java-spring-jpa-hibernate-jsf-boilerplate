package com.stoneapple.boilerplate.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.stoneapple.boilerplate.service.PersonService;
import com.stoneapple.boilerplate.dao.PersonDao;
import com.stoneapple.boilerplate.model.Person;

@Service("personService")
@Transactional(propagation = Propagation.REQUIRED)
public class PersonServiceImpl implements PersonService {

    @Autowired
	private PersonDao personDao;

	public void savePerson(Person person) {
        personDao.create(person);
	}

	public List<Person> findAllPerson() {
        return personDao.findAll();
	}

    @Override
    public Person findByEmail(String email) {
        return personDao.findByEmail(email);
    }

}
