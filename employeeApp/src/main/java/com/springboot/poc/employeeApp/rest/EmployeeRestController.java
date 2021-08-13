package com.springboot.poc.employeeApp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.poc.employeeApp.data.EmployeeData;
import com.springboot.poc.employeeApp.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeData employeeData;
	
	@Autowired
	public EmployeeRestController(EmployeeData employeeDAO) {
		this.employeeData = employeeDAO;
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeData.getAllEmployees();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {
		
		Employee employee = employeeData.getEmployeeById(employeeId);
		
		if(employee == null) {
			throw new EmployeeNotFoundException("Employee not found id-"+employeeId);
		}
		
		return employee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		employee.setEmpId(0);
		
		employeeData.saveEmployee(employee);
		
		return employee;

	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		
		employeeData.saveEmployee(employee);
		
		return employee;
	}
	
	@DeleteMapping("/employees/{empId}")
	public String deleteEmployee(@PathVariable int empId) {
		
		Employee employee = employeeData.getEmployeeById(empId);
		
		if(employee==null)
			throw new EmployeeNotFoundException("No Employee found with id- "+empId+" to delete!");
		
		employeeData.deleteEmployeeById(empId);
		
		return "Employee with Id "+empId+" deleted!";
	}

}
