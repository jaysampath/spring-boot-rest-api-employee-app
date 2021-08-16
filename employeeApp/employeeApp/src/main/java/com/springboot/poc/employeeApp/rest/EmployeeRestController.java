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

import com.springboot.poc.employeeApp.dao.EmployeeDAO;
import com.springboot.poc.employeeApp.entity.Employee;
import com.springboot.poc.employeeApp.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {
		
		Employee employee = employeeService.getEmployeeById(employeeId);
		
		if(employee == null) {
			throw new EmployeeNotFoundException("Employee not found id-"+employeeId);
		}
		
		return employee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		employee.setEmpId(0);
		
		employeeService.saveEmployee(employee);
		
		return employee;

	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		
		employeeService.saveEmployee(employee);
		
		return employee;
	}
	
	@DeleteMapping("/employees/{empId}")
	public String deleteEmployee(@PathVariable int empId) {
		
		Employee employee = employeeService.getEmployeeById(empId);
		
		if(employee==null)
			throw new EmployeeNotFoundException("No Employee found with id- "+empId+" to delete!");
		
		employeeService.deleteEmployee(empId);
		
		return "Employee with Id "+empId+" deleted!";
	}

}
