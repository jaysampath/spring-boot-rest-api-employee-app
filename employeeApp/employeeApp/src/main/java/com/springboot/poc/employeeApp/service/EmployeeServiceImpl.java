package com.springboot.poc.employeeApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.poc.employeeApp.dao.EmployeeDAO;
import com.springboot.poc.employeeApp.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employees = employeeDAO.getAllEmployees();
		return employees;
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		Employee employee = employeeDAO.getEmployeeById(id);
		
		return employee;
	}

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDAO.saveEmployee(employee);
		
	}

	@Override
	@Transactional
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		employeeDAO.deleteEmployeeById(id);
	}

}
