package com.codecool.boot.teatype;

public class TeaTypeService {

    private TeaTypeRepository repository;

    public TeaTypeService(TeaTypeRepository repository) {
        this.repository = repository;
    }

    public Iterable<TeaType> findAll() {
        return this.repository.findAll();
    }

    public TeaType findOne(Integer id) {
        return this.repository.findOne(id);
    }

    public TeaType save(TeaType teaType) {
        this.repository.save(teaType);
        return teaType;
    }
}
