package com.stoneapple.boilerplate.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

import com.stoneapple.boilerplate.dao.GenericDao;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    private Class<T> klass;

    public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        klass = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public T create(final T t) {
        entityManager.persist(t);
        return t;
    }

    @Override
    public void delete(final Object id) {
        entityManager.remove(entityManager.getReference(klass, id));
    }

    @Override
    public T find(final Object id) {
        return (T) entityManager.find(klass, id);
    }

    @Override
    public List<T> findAll() {
        return entityManager.createQuery("SELECT obj FROM " + klass.getSimpleName() + " obj").getResultList();
    }

    @Override
    public T update(final T t) {
        return entityManager.merge(t);
    }
}
