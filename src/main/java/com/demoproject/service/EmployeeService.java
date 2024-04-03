package com.demoproject.service;

import java.util.List;

import com.demoproject.dto.EmployeeDto;
import com.demoproject.entity.Employee;

public interface EmployeeService {
	
	public EmployeeDto findEmployeeById(Long empId);
	
	public List<EmployeeDto> findAllEmployees();

	public EmployeeDto saveEmployee(EmployeeDto emp);

	public String deleteEmployee(Long empId);

}
