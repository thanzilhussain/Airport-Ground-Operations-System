package com.dorm.fuelproject.exception;

public class FlightNotFoundException extends RuntimeException{
    public FlightNotFoundException(String msg){
        super(msg);
    }
}

