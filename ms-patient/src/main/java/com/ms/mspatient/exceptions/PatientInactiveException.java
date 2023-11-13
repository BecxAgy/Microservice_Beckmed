package com.ms.mspatient.exceptions;

public class PatientInactiveException extends RuntimeException{
    public PatientInactiveException(String message){
        super(message);
    }

}
