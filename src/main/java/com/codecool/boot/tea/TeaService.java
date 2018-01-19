package com.codecool.boot.tea;

import com.codecool.boot.common.LoggerInterface;
import com.codecool.boot.common.Service;
import com.codecool.boot.common.exceptions.NoSuchIdException;

import java.util.HashSet;
import java.util.Set;

@org.springframework.stereotype.Service
public class TeaService implements Service<Tea>{

    private TeaRepository repository;
    private LoggerInterface logger;

    public TeaService(TeaRepository repository, LoggerInterface logger) {
        this.repository = repository;
        this.logger = logger;
    }

    @Override
    public Iterable<Tea> findAll() {
        Iterable<Tea> allTeas = this.repository.findAllByIsArchivedIsFalse();
        Set<Tea> availableTeas = new HashSet<>();
        for (Tea tea : allTeas) {
            if (!tea.getTeaType().isArchived()) {
                availableTeas.add(tea);
            }
        }
        logger.logReadAll();
        return availableTeas;
    }

    @Override
    public Tea findOne(Integer id) throws NoSuchIdException {

        Tea tea = this.repository.findOne(id);
        if (tea == null || tea.isArchived() || tea.getTeaType().isArchived()) {
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
