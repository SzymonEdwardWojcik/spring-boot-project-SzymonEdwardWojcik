package com.codecool.boot.common;

public interface Service<T> {

    Iterable<T> findAll();
    T findOne(Integer id);
    T save(T t);
    T put(T t);
    void deleteById(Integer id);
    void archive(Integer id);
}
