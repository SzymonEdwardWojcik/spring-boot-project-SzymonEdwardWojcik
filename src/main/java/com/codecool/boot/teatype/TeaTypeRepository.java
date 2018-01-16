package com.codecool.boot.teatype;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeaTypeRepository extends CrudRepository<TeaType, Integer>{

}
