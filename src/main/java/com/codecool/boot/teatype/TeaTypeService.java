package com.codecool.boot.teatype;

import com.codecool.boot.common.Service;

@org.springframework.stereotype.Service
public class TeaTypeService implements Service<TeaType> {

    private TeaTypeRepository repository;

    public TeaTypeService(TeaTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<TeaType> findAll() {
        return this.repository.findAll();
    }

    @Override
    public TeaType findOne(Integer id) {
        return this.repository.findOne(id);
    }

    @Override
    public TeaType save(TeaType teaType) {
        return this.repository.save(teaType);
    }

    @Override
    public TeaType put(TeaType teaType) {
        return this.repository.save(teaType);
    }

    @Override
    public void deleteById(Integer id) {
        this.repository.delete(id);
    }
}
