package com.ms.msappointment.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler(PatientAlreadyHasAppointmentException.class)
    public ResponseEntity<Object> handlePatientAlreadyHasAppointmentException (PatientAlreadyHasAppointmentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ClinicOutOfOperationException.class)
    public ResponseEntity<Object> handleClinicOutOfOperationException (ClinicOutOfOperationException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(TimeAlreadyBookedException.class)
    public ResponseEntity<Object> handleTimeAlreadyBookedException(TimeAlreadyBookedException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidAppointmentException.class)
    public ResponseEntity<Object> handleTimeAlreadyBookedException(InvalidAppointmentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidCancelationException.class)
    public ResponseEntity<Object> handleTimeAlreadyBookedException(InvalidCancelationException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
