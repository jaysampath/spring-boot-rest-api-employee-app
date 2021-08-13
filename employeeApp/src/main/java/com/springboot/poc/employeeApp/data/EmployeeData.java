package com.springboot.poc.employeeApp.data;

import java.util.List;

import com.springboot.poc.employeeApp.entity.Employee;

public interface EmployeeData {
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(int id);
	
	public void saveEmployee(Employee employee);
	
	public void deleteEmployeeById(int id);

}
