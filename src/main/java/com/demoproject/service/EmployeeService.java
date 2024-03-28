package com.demoproject.service;

import java.util.List;

import com.demoproject.dto.EmployeeDto;
import com.demoproject.entity.Employee;

public interface EmployeeService {
	
	public Employee findEmployeeById(Long empId);
	
	public List<Employee> findAllEmployees();

	public Employee saveEmployee(EmployeeDto emp);

}
