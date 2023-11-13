package com.ms.msappointment.exceptions;

public class PatientAlreadyHasAppointmentException extends RuntimeException {
    public PatientAlreadyHasAppointmentException(String message) {
        super(message);
    }
}
