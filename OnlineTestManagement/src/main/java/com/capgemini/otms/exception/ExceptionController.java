package com.capgemini.otms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class ExceptionController {
	@ExceptionHandler(value = EntityAlreadyExists.class)
	public ResponseEntity<Object> handleEntityAlreadyExists(EntityAlreadyExists exception) {

		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = EntityNotFoundException.class)
	
	public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

}
