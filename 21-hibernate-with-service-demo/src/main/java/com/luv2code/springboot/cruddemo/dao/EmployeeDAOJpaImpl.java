package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	// define field for entitymanager
	private EntityManager entityManager;
	
	// set up constructor injection
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		
		// create a query
		Query query = 
				entityManager.createQuery("from Employee");
		
		// Execute query and get the result list
		List<Employee> employees = query.getResultList();
		
		// return the result		
		return employees;
	}

	@Override
	public Employee findById(int id) {
		
		// get the employee
		Employee employee = entityManager.find(Employee.class, id);
		
		// return the employee		
		return employee;
	}

	@Override
	public void save(Employee employee) {
		
		// save the employee
		Employee dbEmployee = entityManager.merge(employee);
		
		// update with id from db ... so we can get generated id for save/insert
		employee.setId(dbEmployee.getId());
		
	}

	@Override
	public void deleteById(int id) {
		
		// delete object with primary key
		Query query = entityManager.createQuery(
				"delete from Employee where id=:employeeId");
		
		query.setParameter("employeeId", id);
		
		query.executeUpdate();
		
	}

	
	
}
