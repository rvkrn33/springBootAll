package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.DataNotFound;

@RestControllerAdvice
public class ControllerAdviceException {

	@ExceptionHandler(value=DataNotFound.class)
	public ResponseEntity<Object> handledException(DataNotFound ex){
		return new ResponseEntity<Object>("Data not found",HttpStatus.NOT_FOUND);
	}
}
