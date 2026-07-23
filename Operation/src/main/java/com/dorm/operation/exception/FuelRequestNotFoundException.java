package com.dorm.operation.exception;

public class FuelRequestNotFoundException extends RuntimeException{
    public FuelRequestNotFoundException(String msg){
        super(msg);
    }
}
