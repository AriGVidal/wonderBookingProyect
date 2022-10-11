package com.house.digital.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.house.digital.dto.ExceptionResponseDto;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<Object> filterResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		   
	    ExceptionResponseDto exceptionResponse = new ExceptionResponseDto(String.valueOf(status.value()), status.name(),
				ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse, status);
	}
	
	@ExceptionHandler(ResourceFoundException.class)
	public final ResponseEntity<Object> filterResourceFoundException(ResourceFoundException ex, WebRequest request) {
		
		HttpStatus status = HttpStatus.CONFLICT;
		   
	    ExceptionResponseDto exceptionResponse = new ExceptionResponseDto(String.valueOf(status.value()), status.name(),
				ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse, status);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object>handleException(WebRequest request, Exception ex) {

		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

		ExceptionResponseDto exceptionResponse = new ExceptionResponseDto(String.valueOf(status.value()), status.name(),
				"Ha ocurrido un error inesperado, estamos trabajando en ello", request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, status);
	}
}
