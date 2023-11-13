package com.ms.msappointment.exceptions;

public class InvalidCancelationException extends  RuntimeException{
    public InvalidCancelationException(String message){
        super(message);
    }
}