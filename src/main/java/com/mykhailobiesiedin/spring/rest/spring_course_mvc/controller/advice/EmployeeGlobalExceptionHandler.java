package com.mykhailobiesiedin.spring.rest.spring_course_mvc.controller.advice;

import com.mykhailobiesiedin.spring.rest.spring_course_mvc.exceptions.EmployeeIncorrectData;
import com.mykhailobiesiedin.spring.rest.spring_course_mvc.exceptions.NoSuchEmployeeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class EmployeeGlobalExceptionHandler {

    @ExceptionHandler(NoSuchEmployeeException.class)
    public ResponseEntity<EmployeeIncorrectData> employeeNotFoundException(
            Exception exception) {
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.I_AM_A_TEAPOT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<EmployeeIncorrectData> handleException(
            Exception exception) {
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.I_AM_A_TEAPOT);
    }
}
