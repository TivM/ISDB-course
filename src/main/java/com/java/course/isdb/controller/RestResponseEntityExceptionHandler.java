package com.java.course.isdb.controller;

import com.java.course.isdb.dto.response.ApiErrorResponse;
import com.java.course.isdb.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;
import java.util.Arrays;
@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends
        ResponseEntityExceptionHandler {

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<ApiErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ResponseEntity<>(
                new ApiErrorResponse(
                        "Something not found or doesn't exist",
                        "0",
                        "Resource not found",
                        ex.getMessage(),
                        Arrays.stream(ex.getStackTrace())
                                .map(StackTraceElement::toString)
                                .toList()
                ),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler({SQLException.class})
    public ResponseEntity<ApiErrorResponse> handleResourceNotFoundException(SQLException ex) {
        return new ResponseEntity<>(
                new ApiErrorResponse(
                        "PSQL Exception",
                        "0",
                        "Wrong sql procedure",
                        ex.getMessage(),
                        Arrays.stream(ex.getStackTrace())
                                .map(StackTraceElement::toString)
                                .toList()
                ),
                HttpStatus.BAD_REQUEST
        );
    }
}
