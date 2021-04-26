package com.escola.demo.controller.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.escola.demo.service.exceptions.ResourceAlreadyExistsException;
import com.escola.demo.service.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	private ResponseEntity<StandardError> handlerBuilder(String error, HttpStatus status, Exception e,
			HttpServletRequest request) {
		StandardError standardError = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(standardError);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFOund(HttpServletRequest request, ResourceNotFoundException e) {
		String error = "Resource not Found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		return handlerBuilder(error, status, e, request);

	}

	@ExceptionHandler(ResourceAlreadyExistsException.class)
	public ResponseEntity<StandardError> resourceAlreadyExists(HttpServletRequest request,
			ResourceAlreadyExistsException e) {
		String error = "Resource already exists";
		HttpStatus status = HttpStatus.ALREADY_REPORTED;
		return handlerBuilder(error, status, e, request);
	}
}