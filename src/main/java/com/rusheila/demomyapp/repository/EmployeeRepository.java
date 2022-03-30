package com.rusheila.demomyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rusheila.demomyapp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
