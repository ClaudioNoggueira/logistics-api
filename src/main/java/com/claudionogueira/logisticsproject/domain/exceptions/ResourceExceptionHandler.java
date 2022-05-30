package com.claudionogueira.logisticsproject.domain.exceptions;

import java.time.OffsetDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(DomainException.class)
	public ResponseEntity<Object> handleDomainException(DomainException e, WebRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError error = new StandardError(OffsetDateTime.now(), status.value(), "Domain error", e.getMessage());
		return handleExceptionInternal(e, error, new HttpHeaders(), status, request);
	}

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError error = new StandardError(OffsetDateTime.now(), status.value(), "Not found", e.getMessage());
		return ResponseEntity.status(status).body(error);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		StandardError error = new StandardError(OffsetDateTime.now(), status.value(), "Invalid argument", null);

		for (ObjectError oe : ex.getBindingResult().getAllErrors()) {
			String name = ((FieldError) oe).getField();
			String message = oe.getDefaultMessage();
			error.addField(name, message);
		}

		return handleExceptionInternal(ex, error, headers, status, request);
	}
}
