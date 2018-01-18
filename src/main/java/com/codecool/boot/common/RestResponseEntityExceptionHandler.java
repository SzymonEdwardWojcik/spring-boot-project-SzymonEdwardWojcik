package com.codecool.boot.common;

import com.codecool.boot.common.exceptions.ApiError;
import com.codecool.boot.common.exceptions.NoSuchIdException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchIdException.class)
    protected ResponseEntity<ApiError> handleNoSuchIdException() {

        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND,
                "There is no record with such ID");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }


}