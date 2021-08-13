package com.springboot.poc.employeeApp.rest;

public class EmployeeNotFoundException extends RuntimeException {
    
	public EmployeeNotFoundException(String message) {
		super(message);
	}
     
	
}
