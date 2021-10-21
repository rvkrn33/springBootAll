package com.first.first.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value=CustomException.class)
	public ResponseEntity<?> handledException(CustomException ex){
		return new ResponseEntity("Data not available.",HttpStatus.NOT_FOUND);
	}
}
