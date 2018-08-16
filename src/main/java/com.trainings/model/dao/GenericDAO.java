package com.trainings.model.dao;

import java.util.List;

public interface GenericDAO<E,K> {
    void create (E entity);
    E findById(K id);
    List<E> findAll();
    void update(E entity);
    void delete(K id);
}
