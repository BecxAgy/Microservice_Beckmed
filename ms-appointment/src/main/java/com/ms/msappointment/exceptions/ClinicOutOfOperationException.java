package com.ms.msappointment.exceptions;

public class ClinicOutOfOperationException extends  RuntimeException{
    public ClinicOutOfOperationException(String message){
        super(message);
    }
}
