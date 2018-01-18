package com.codecool.boot.common;

import com.codecool.boot.common.exceptions.ApiError;
import com.codecool.boot.common.exceptions.NoSuchIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    LoggerInterface logger;

    public RestResponseEntityExceptionHandler(LoggerInterface logger) {
        this.logger = logger;
    }

    @ExceptionHandler(NoSuchIdException.class)
    protected ResponseEntity<ApiError> handleNoSuchIdException() {

        String message = "There is no record with such ID";
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND,
                message);

        logger.logError(message);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }


}