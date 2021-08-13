package com.springboot.poc.employeeApp.rest;

import java.text.SimpleDateFormat;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalRestExceptionHandler {
	
	SimpleDateFormat sdf = new SimpleDateFormat();
     
	@ExceptionHandler
	public ResponseEntity<EmployeeNotFoundErrorResponce> handleException(EmployeeNotFoundException e){
		
		EmployeeNotFoundErrorResponce error = new EmployeeNotFoundErrorResponce(
											HttpStatus.NOT_FOUND.value(), 
											e.getMessage(),
											String.valueOf(sdf.format(System.currentTimeMillis()))
											);
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<EmployeeNotFoundErrorResponce> handleException(Exception e){
		
		EmployeeNotFoundErrorResponce error = new EmployeeNotFoundErrorResponce(
											HttpStatus.BAD_REQUEST.value(), 
											//"employee not found with given id",
											e.getMessage(),
											String.valueOf(sdf.format(System.currentTimeMillis()))											);
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
}
