package com.rusheila.demomyapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rusheila.demomyapp.entity.Employee;
import com.rusheila.demomyapp.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping()
	public String view(Model model, @RequestParam(name="submit", required = false) String submitStatus) {
		model.addAttribute("employee", new Employee());
		if(submitStatus  != null && submitStatus.equals("1")) {
			model.addAttribute("submitStatus", true);
		}
		List<Employee> employees = this.employeeService.getAllEmployees();
		model.addAttribute("employees", employees);
		
		return "employeeform"; //find employeeform.html
	}
	
	@PostMapping("/proses")
	public String prosesData(@ModelAttribute("employee") Employee employee) {
		
		System.out.println("hello"+ employee.getName());
		this.employeeService.save(employee);
		return "redirect:/employee?submit=1";
}
}
