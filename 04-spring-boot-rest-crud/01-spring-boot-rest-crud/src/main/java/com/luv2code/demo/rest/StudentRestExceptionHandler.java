package com.luv2code.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    //add exception handling code here
    //Add an exception handler using @ExceptionHandler
    @ExceptionHandler   //ExceptionHandler annotation to define the method below is the Exception handler method
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){ //StudentErrorResponse: type of the response body; StudentNotFoundException: exception type to handle/catch

        //create a StudentErrorResponse
        StudentErrorResponse err = new StudentErrorResponse();
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage(exc.getMessage());
        err.setTimestamp(System.currentTimeMillis());

        //return ResponseEntity
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND); //err:body, HttpStatus.NOT_FOUND: status code
    }

    //Add another exception handler to catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){ //Exception: handle generic exceptions

        //create a StudentErrorResponse
        StudentErrorResponse err = new StudentErrorResponse();
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setMessage(exc.getMessage());
        err.setTimestamp(System.currentTimeMillis());

        //return ResponseEntity
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

}
