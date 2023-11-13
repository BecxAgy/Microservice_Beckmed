package com.ms.msappointment.exceptions;

public class AppointmentNotFoundException extends  RuntimeException{
    public AppointmentNotFoundException(String message){
        super(message);
    }
}