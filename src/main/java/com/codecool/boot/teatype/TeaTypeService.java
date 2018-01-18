package com.codecool.boot.teatype;

import com.codecool.boot.common.Service;
import com.codecool.boot.common.exceptions.NoSuchIdException;
import com.codecool.boot.tea.Tea;

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
    public TeaType findOne(Integer id) throws NoSuchIdException {

        TeaType teaType = this.repository.findOne(id);
        if (teaType == null) {
            throw new NoSuchIdException();
        }
        return teaType;
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

    public void archive(Integer id) {
        TeaType teaType = this.repository.findOne(id);
        teaType.setArchived(true);
        archiveTeas(teaType);
        this.repository.save(teaType);
    }

    public void archiveTeas(TeaType teaType) {
        for (Tea tea : teaType.getTeas()) {
            tea.setArchived(true);
        }
    }
}
