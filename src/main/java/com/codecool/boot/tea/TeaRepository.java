package com.codecool.boot.tea;

import org.springframework.data.repository.CrudRepository;

public interface TeaRepository extends CrudRepository<Tea, Integer> {

    Iterable<Tea> findAllByIsArchivedIsFalse();
}
