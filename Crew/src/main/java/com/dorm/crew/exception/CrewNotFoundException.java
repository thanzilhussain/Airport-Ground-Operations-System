package com.dorm.crew.exception;

public class CrewNotFoundException extends RuntimeException{
    public CrewNotFoundException(String msg){
        super(msg);
    }
}
