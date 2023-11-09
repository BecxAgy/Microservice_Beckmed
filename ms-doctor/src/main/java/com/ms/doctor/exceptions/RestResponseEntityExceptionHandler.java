package com.ms.doctor.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler(DoctorNotFoundException.class)
    public ResponseEntity<Object> handleDoctorNotFoundException(DoctorNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(DoctorInactiveException.class)
    public ResponseEntity<Object> handleDoctorInactiveException(DoctorInactiveException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
