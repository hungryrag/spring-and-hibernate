package com.luv2code.springboot.cruddemo.rest;

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

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	// expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}
	
	// expose "/employees/{employeeId}" and return the employee
	@GetMapping("/employees/{employeeId}")
	public Employee findById(@PathVariable int employeeId) {
		
		Employee employee =  employeeService.findById(employeeId);
		
		if (employee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		return employee;
	}
	
	// add mapping for POST /employee - add new employee
	@PostMapping("/employees")
	public Employee save(@RequestBody Employee employee) {
		
		// just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		employee.setId(0);
		
		employeeService.save(employee);
		
		return employee;
		
	}
	
	// add mapping for PUT /employee - update an employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		
		employeeService.save(employee);
		
		return employee;
	}
	
	// add mapping for DELETE /employee/{employeeId} - delete an employee
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee employee = employeeService.findById(employeeId);
		
		if (employee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		employeeService.deleteById(employeeId);
		
		return "Deleted employee id - " + employeeId;
		
	}
}




























