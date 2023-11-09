package com.mykhailobiesiedin.spring.rest.spring_course_mvc.exceptions;

public class NoSuchEmployeeException extends RuntimeException{

    public NoSuchEmployeeException (String message){
        super(message);
    }
}
