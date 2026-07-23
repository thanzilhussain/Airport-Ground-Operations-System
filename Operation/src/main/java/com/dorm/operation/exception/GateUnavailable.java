package com.dorm.operation.exception;

public class GateUnavailable extends RuntimeException{
    public GateUnavailable(String msg){
        super(msg);
    }
}
