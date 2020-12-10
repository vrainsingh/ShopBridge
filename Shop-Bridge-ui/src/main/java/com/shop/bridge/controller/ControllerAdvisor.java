package com.shop.bridge.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.shop.bridge.pojo.GenericException;
import com.shop.bridge.pojo.GenericResponse;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

	@ExceptionHandler(GenericException.class)
	public ResponseEntity<GenericResponse> handleCityNotFoundException(GenericException ex, WebRequest request) {
		return new ResponseEntity<>(new GenericResponse(ex.getMessage(), ex.getStatusCode()), HttpStatus.CONFLICT);
	}

	@ExceptionHandler(Exception.class)
	public GenericResponse exceptionHanlder(Exception exception, WebRequest request) {
		return new GenericResponse("internal server error", 280);
	}

}