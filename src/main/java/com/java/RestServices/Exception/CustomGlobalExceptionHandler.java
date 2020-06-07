package com.java.RestServices.Exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	// Method argument not valid exception

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		CustomErrorDetails ced = new CustomErrorDetails(new Date(), "This is custom message fro handleMethodArgumentNotValid", ex.getMessage());
		return new ResponseEntity<Object>(ced, HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		CustomErrorDetails ced = new CustomErrorDetails(new Date(), "This is custom message fro handleHttpRequestMethodNotSupported", ex.getMessage());
		return new ResponseEntity<Object>(ced, HttpStatus.METHOD_NOT_ALLOWED);
	}
	@ExceptionHandler(UserNameNotFoundException.class)
	public ResponseEntity<Object> handleUserNameNotFoundException(UserNameNotFoundException ex, WebRequest request) {
		CustomErrorDetails ced = new CustomErrorDetails(new Date(), ex.getMessage(),  request.getDescription(true));
		return new ResponseEntity<Object>(ced, HttpStatus.NOT_FOUND);
	}

}
