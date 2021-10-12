package com.mainteneceapp.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mainteneceapp.model.ApiErrors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(MaintenenceNotFoundException.class)
	protected ResponseEntity<Object> handleMaintenenceNotFoundException(MaintenenceNotFoundException ex){
		String message = ex.getMessage();
		LocalDateTime timeStamp = LocalDateTime.now();
		String error = "Maintenence not available";
		ApiErrors errors = new ApiErrors(timeStamp,message,HttpStatus.CONFLICT.value(),error);
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(errors);
	}
}
