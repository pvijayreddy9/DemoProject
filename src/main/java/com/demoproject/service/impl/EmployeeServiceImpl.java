package com.demoproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoproject.dao.EmployeeRepository;
import com.demoproject.dto.EmployeeDto;
import com.demoproject.entity.Employee;
import com.demoproject.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository empRepository;

	@Override
	public Employee findEmployeeById(Long empId) {
		
		return empRepository.findById(empId).get();
	}

	@Override
	public List<Employee> findAllEmployees() {
		
		return empRepository.findAll();
	}

	@Override
	public Employee saveEmployee(EmployeeDto empdto) {
		Employee emp = new Employee(empdto);
		return empRepository.save(emp);
	}

}
