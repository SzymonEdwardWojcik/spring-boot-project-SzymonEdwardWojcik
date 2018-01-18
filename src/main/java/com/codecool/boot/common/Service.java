package com.codecool.boot.common;

import com.codecool.boot.common.exceptions.NoSuchIdException;

public interface Service<T> {

    Iterable<T> findAll();
    T findOne(Integer id) throws NoSuchIdException;
    T save(T t);
    T put(T t);
    void deleteById(Integer id);
    void archive(Integer id);
}
