package com.rusheila.demomyapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rusheila.demomyapp.entity.Employee;
import com.rusheila.demomyapp.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public void save(Employee employee) {
		this.employeeRepository.save(employee);

}
	public List<Employee> getAllEmployees() {
		return this.employeeRepository.findAll();
	}
}
