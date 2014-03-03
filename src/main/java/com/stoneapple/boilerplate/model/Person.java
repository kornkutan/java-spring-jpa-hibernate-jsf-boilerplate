package com.stoneapple.boilerplate.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

@Entity
@Table(name = "PERSON")
@NamedQueries({
        @NamedQuery(name = "Person.findByName",
                query = "SELECT p FROM Person p WHERE p.name = :name"),
        @NamedQuery(name = "Person.findByEmail",
                query = "SELECT p FROM Person p WHERE p.email = :email")
})
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    private String name;
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("email", email)
                .toString();
    }
}
