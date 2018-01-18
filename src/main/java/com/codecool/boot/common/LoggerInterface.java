package com.codecool.boot.common;

public interface LoggerInterface {

    void logError(String message);
    void logCreate(String message);
    void logReadOne(String message);
    void logReadAll();
    void logUpdate(String message);
    void logArchive(String message);
}
