package com.example.demo.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exceptions.CustomerExceptions;

@RestControllerAdvice
public class ExceptionController {

	
	@ExceptionHandler(value =CustomerExceptions.class)
	public ResponseEntity<Object> handleExceptions(CustomerExceptions exception) {
		      return new ResponseEntity<>(" Data not found", HttpStatus.NOT_FOUND);
	}
	
}
