package com.stoneapple.boilerplate.test;


import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.stoneapple.boilerplate.model.Person;
import com.stoneapple.boilerplate.service.PersonService;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:application-context.xml"})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class ServiceTest {

    @Autowired
    PersonService personService;

    private final String name = "Korn";
    private final String email = "korn.kutan@stone-apple.com";

    @Test
    public void testPersonService() {
        Person person = new Person();
        person.setName(name);
        person.setEmail(email);

        assertEquals(personService.findAllPerson().size(), 0);

        personService.savePerson(person);
        person = personService.findByEmail(email);

        assertNotNull(person.getId());
        assertTrue(person.getName().equals(name));
    }

}
