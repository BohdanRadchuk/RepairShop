package com.trainings.model.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<E,K> extends AutoCloseable{
    boolean create (E entity);
    Optional<E> findById(K id);
    List<E> findAll();
    boolean update(E entity);
    boolean delete(K id);
}
