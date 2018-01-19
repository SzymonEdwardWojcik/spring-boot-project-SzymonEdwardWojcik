package com.codecool.boot.teatype;

import com.codecool.boot.common.LoggerInterface;
import com.codecool.boot.common.Service;
import com.codecool.boot.common.exceptions.NoSuchIdException;
import com.codecool.boot.tea.Tea;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class TeaTypeService implements Service<TeaType> {

    private TeaTypeRepository repository;
    private LoggerInterface logger;

    public TeaTypeService(TeaTypeRepository repository, LoggerInterface logger) {
        this.repository = repository;
        this.logger = logger;
    }

    @Override
    public Iterable<TeaType> findAll() {

        Iterable<TeaType> types = this.repository.findAllByIsArchivedIsFalse();
        for (TeaType teaType : types) {
            removeArchivedTeas(teaType);
        }
        logger.logReadAll();
        return types;
    }

    @Override
    public TeaType findOne(Integer id) throws NoSuchIdException {

        TeaType teaType = this.repository.findOne(id);
        if (teaType == null || teaType.isArchived()) {
            throw new NoSuchIdException();
        }
        logger.logReadOne(teaType.toString());
        return teaType;
    }

    @Override
    public TeaType save(TeaType teaType) {

        this.repository.save(teaType);
        logger.logCreate(teaType.toString());
        return teaType;
    }

    @Override
    public TeaType put(TeaType teaType) {
        this.repository.save(teaType);
        logger.logUpdate(teaType.toString());
        return teaType;
    }

    @Override
    @Deprecated
    public void deleteById(Integer id) {
        this.repository.delete(id);
    }

    public void archive(Integer id) {
        TeaType teaType = this.repository.findOne(id);
        teaType.setArchived(true);
        archiveTeas(teaType);
        this.repository.save(teaType);
        logger.logArchive(teaType.toString());
    }

    public void archiveTeas(TeaType teaType) {
        for (Tea tea : teaType.getTeas()) {
            tea.setArchived(true);
        }
    }

    public void removeArchivedTeas(TeaType teaType) {
        List<Tea> teas = teaType.getTeas().stream()
                                          .filter(tea -> !tea.isArchived())
                                          .collect(Collectors.toList());
        teaType.setTeas(teas);
    }
}
