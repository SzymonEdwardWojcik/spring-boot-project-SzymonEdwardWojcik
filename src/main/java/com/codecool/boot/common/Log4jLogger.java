package com.codecool.boot.common;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Log4jLogger implements LoggerInterface {

    private final static Logger logger = Logger.getLogger(Log4jLogger.class.getName());

    @Override
    public void logError(String message) {
        logger.error(message);
    }

    @Override
    public void logCreate(String json) {
        logger.info("Created new record: " + json);
    }

    @Override
    public void logReadOne(String json) {
        logger.info("Read object: " + json);
    }

    @Override
    public void logReadAll() {
        logger.info("Read all records");
    }

    @Override
    public void logUpdate(String json) {
        logger.info("Updated record to: " + json);
    }

    @Override
    public void logArchive(String json) {
        logger.info("Archived record: " + json);
    }
}
