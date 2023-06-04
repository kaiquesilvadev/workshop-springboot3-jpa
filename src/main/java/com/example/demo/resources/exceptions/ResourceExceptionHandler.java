package com.example.demo.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.services.exceptions.DatabaseException;
import com.example.demo.services.exceptions.ResoucerNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice // pegas as exceções e traz para ser tratada aqui
public class ResourceExceptionHandler {

	@ExceptionHandler(ResoucerNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResoucerNotFoundException e, HttpServletRequest request) {
		String error = "recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
		String error = "não encontrado no banco de dados";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}
