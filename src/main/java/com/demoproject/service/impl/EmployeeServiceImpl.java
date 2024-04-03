package com.demoproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoproject.dao.EmployeeRepository;
import com.demoproject.dto.EmployeeDto;
import com.demoproject.entity.Employee;
import com.demoproject.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository empRepository;
	
	@Autowired
	ObjectMapper objMapper;

	@Override
	public EmployeeDto findEmployeeById(Long empId) {
		
		return objMapper.convertValue(empRepository.findById(empId).get(), EmployeeDto.class);
	}

	@Override
	public List<EmployeeDto> findAllEmployees() {
		List<Employee> empList = empRepository.findAll();
		return Employee.convertToDto(empList);
	}

	@Override
	public EmployeeDto saveEmployee(EmployeeDto empdto) {
		Employee emp = objMapper.convertValue(empdto, Employee.class);
		return objMapper.convertValue(empRepository.save(emp), EmployeeDto.class);
	}

	@Override
	public String deleteEmployee(Long empId) {
		Employee emp = new Employee();
		emp.setEmpId(empId);
		empRepository.delete(emp);
		return "Deleted Successfully";
	}

}
