package com.ms.mspatient.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<Object> handleDoctorNotFoundException(PatientNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PatientInactiveException.class)
    public ResponseEntity<Object> handlePatientInactiveException(PatientInactiveException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }



}
