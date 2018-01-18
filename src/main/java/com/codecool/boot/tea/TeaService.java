package com.codecool.boot.tea;

import com.codecool.boot.common.Service;
import com.codecool.boot.teatype.TeaType;

@org.springframework.stereotype.Service
public class TeaService implements Service<Tea>{

    TeaRepository repository;

    public TeaService(TeaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Tea> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Tea findOne(Integer id) {
        return this.repository.findOne(id);
    }

    @Override
    public Tea save(Tea tea) {
        return this.repository.save(tea);
    }

    @Override
    public Tea put(Tea tea) {
        return this.repository.save(tea);
    }

    @Deprecated
    @Override
    public void deleteById(Integer id) {
        this.repository.delete(id);
    }

    public void archive(Integer id) {
        Tea tea = this.repository.findOne(id);
        tea.setArchived(true);
        this.repository.save(tea);
    }
}
