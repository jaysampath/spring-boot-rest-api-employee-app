package com.springboot.poc.employeeApp.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.poc.employeeApp.entity.Employee;

@Repository
public class EmployeeDataImplementation implements EmployeeData {
	
	
	private EntityManager entityManager;
	
	public EmployeeDataImplementation(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		
		Session session = entityManager.unwrap(Session.class);
		
		Query query = session.createQuery("from Employee order by empId asc");
		
		List<Employee> employees = query.getResultList();
		
		return employees;
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		
		Session session = entityManager.unwrap(Session.class);
		
		Employee employee = session.get(Employee.class, id);
		
		return employee;
	}

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(employee);

	}

	@Override
	@Transactional
	public void deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		
		Query query = session.createQuery("delete from Employee where empId=:id");
		
		query.setParameter("id", id);
		
		query.executeUpdate();
	}

}
