package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	// add mapping for "/list"
	@GetMapping("/list")
	public String listEmployees(Model model) {
		
		// get the employees from db
		List<Employee> employees = employeeService.findAll();
		
		// add to the spring model
		model.addAttribute("employees", employees);
		
		return "employees/list-employees";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		// create model attribute to bind form data
		Employee employee = new Employee();
		
		model.addAttribute("employee", employee);
		
		return "employees/employee-form";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {
		
		// get the employee from the service
		Employee employee = employeeService.findById(id);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("employee", employee);
		
		// send over to form
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		
		// save the employee
		employeeService.save(employee);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
		
	}
	
}
