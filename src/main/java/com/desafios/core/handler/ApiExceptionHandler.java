package com.desafios.core.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.desafios.core.exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(value = {ResourceNotFoundException.class})
	public ProblemDetail resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
		problem.setDetail(ex.getMessage());
		problem.setTitle("Resource not found");
		return problem;
	}
	
	@ExceptionHandler(value = {IllegalArgumentException.class})
	public ProblemDetail resourceNotFoundExceptions(ResourceNotFoundException ex, WebRequest request) {
		ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.BAD_GATEWAY);
		problem.setDetail(ex.getMessage());
		problem.setTitle("Bad request");
		return problem;
	}

}
