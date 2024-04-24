package com.demoproject.service.impl;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoproject.dao.DepartmentRepository;
import com.demoproject.dao.EmployeeRepository;
import com.demoproject.dto.DepartmentDto;
import com.demoproject.dto.EmployeeDto;
import com.demoproject.entity.Book;
import com.demoproject.entity.Employee;
import com.demoproject.exception.MyCustomException;
import com.demoproject.service.FetchDataService;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class FetchDataServiceImpl implements FetchDataService{
	
	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	DepartmentRepository depRepo;
	
	@Autowired
	ObjectMapper objMapper;
	

	@Override
	public List<?> getResults(String entity) throws MyCustomException {
		if("Employee".equalsIgnoreCase(entity)) {
			List<Employee> emplist = empRepo.findAll();
			
			return emplist.stream().map(a-> objMapper.convertValue(a, EmployeeDto.class)).toList();
			
		}else if(entity.equalsIgnoreCase("Department")){
			return depRepo.findAll().stream().map(a-> objMapper.convertValue(a, DepartmentDto.class)).toList();
		}else {
			throw new MyCustomException("Entity you provided is incorrect");
		}
	}


	@Override
	public Book saveBook(Book book) {
		
		return null;
	}
	
	

}
