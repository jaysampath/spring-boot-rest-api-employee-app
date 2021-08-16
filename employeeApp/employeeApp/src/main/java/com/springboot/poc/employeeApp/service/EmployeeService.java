package com.springboot.poc.employeeApp.service;

import java.util.List;

import com.springboot.poc.employeeApp.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(int id);
	
	public void saveEmployee(Employee employee);
	
	public void deleteEmployee(int id);

}
