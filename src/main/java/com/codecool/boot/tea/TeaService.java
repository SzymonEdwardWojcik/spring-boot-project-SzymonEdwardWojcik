package com.codecool.boot.tea;

import com.codecool.boot.common.LoggerInterface;
import com.codecool.boot.common.Service;
import com.codecool.boot.common.exceptions.NoSuchIdException;

@org.springframework.stereotype.Service
public class TeaService implements Service<Tea>{

    TeaRepository repository;
    private LoggerInterface logger;

    public TeaService(TeaRepository repository, LoggerInterface logger) {
        this.repository = repository;
        this.logger = logger;
    }

    @Override
    public Iterable<Tea> findAll() {
        logger.logReadAll();
        return this.repository.findAll();
    }

    @Override
    public Tea findOne(Integer id) throws NoSuchIdException {

        Tea tea = this.repository.findOne(id);
        if (tea == null) {
            throw new NoSuchIdException();
        }
        logger.logReadOne(tea.toString());
        return tea;
    }

    @Override
    public Tea save(Tea tea) {
        this.repository.save(tea);
        logger.logCreate(tea.toString());
        return tea;
    }

    @Override
    public Tea put(Tea tea) {

        this.repository.save(tea);
        logger.logUpdate(tea.toString());
        return tea;
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
        logger.logArchive(tea.toString());
    }
}
