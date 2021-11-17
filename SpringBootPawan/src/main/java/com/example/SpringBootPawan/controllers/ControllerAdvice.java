package com.example.SpringBootPawan.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.SpringBootPawan.exceptions.DataNotFoundException;

@RestControllerAdvice
public class ControllerAdvice {
	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<String> handleExcaption(DataNotFoundException msg){
		return new ResponseEntity(msg,HttpStatus.NOT_FOUND);
	}

}
