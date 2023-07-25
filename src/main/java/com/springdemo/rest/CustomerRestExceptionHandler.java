package com.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Lab 17.4
@ControllerAdvice
public class CustomerRestExceptionHandler {

	//add exception  handler for CustomerNotFoundException
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc){
		
		//Lab 17.5.
		//create customerErrorResponse
		CustomerErrorResponse error = new  CustomerErrorResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage(), System.currentTimeMillis());
		
		
		//return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND) ;
	}
	
	//Lab 17.6
	//add another exception handler ... to catch all exception (catch all)
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception exc){
		
		
		//create customerErrorResponse
		CustomerErrorResponse error = new  CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(), exc.getMessage(), System.currentTimeMillis());
		
		
		//return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST) ;
	}
	
}
