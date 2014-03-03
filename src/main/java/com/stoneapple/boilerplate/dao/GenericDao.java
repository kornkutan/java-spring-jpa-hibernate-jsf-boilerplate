package com.stoneapple.boilerplate.dao;

import java.util.List;

public interface GenericDao<T> {

    T create(T t);

    void delete(Object id);

    T find(Object id);

    List<T> findAll();

    T update(T t);
}
