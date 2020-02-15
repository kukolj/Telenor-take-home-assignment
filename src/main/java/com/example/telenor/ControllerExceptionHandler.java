package com.example.telenor;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> handle(ConstraintViolationException constraintViolationException) {
		return new ResponseEntity<>(constraintViolationException.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<String> handle(HttpClientErrorException ex) {
		return new ResponseEntity<>(ex.getMessage(), ex.getStatusCode());
	}

}