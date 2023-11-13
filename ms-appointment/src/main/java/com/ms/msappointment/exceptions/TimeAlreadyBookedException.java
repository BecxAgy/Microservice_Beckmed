package com.ms.msappointment.exceptions;



public class TimeAlreadyBookedException extends RuntimeException {
    public  TimeAlreadyBookedException(String message){
        super(message);

    }
}
