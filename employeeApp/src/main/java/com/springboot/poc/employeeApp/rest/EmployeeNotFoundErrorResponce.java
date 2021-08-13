package com.springboot.poc.employeeApp.rest;

public class EmployeeNotFoundErrorResponce {
    
	private Integer status;
	
	private String message;
	
	private String time;

	public EmployeeNotFoundErrorResponce() {
		
	}
	
	public EmployeeNotFoundErrorResponce(Integer status, String message, String time) {
		this.status = status;
		this.message = message;
		this.time = time;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "EmployeeNotFoundErrorResponce [status=" + status + ", message=" + message + ", time=" + time + "]";
	}
	
}
