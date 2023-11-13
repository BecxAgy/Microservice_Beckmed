package com.ms.msappointment.exceptions;

public class NotHaveAvaliableDoctor extends RuntimeException {
    public NotHaveAvaliableDoctor(String message) {
        super(message);
    }
}
