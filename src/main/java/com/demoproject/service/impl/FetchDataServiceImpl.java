package com.demoproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoproject.dao.DepartmentRepository;
import com.demoproject.dao.EmployeeRepository;
import com.demoproject.exception.MyCustomException;
import com.demoproject.service.FetchDataService;
@Service
public class FetchDataServiceImpl implements FetchDataService{
	
	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	DepartmentRepository depRepo;

	@Override
	public List<?> getResults(String entity) throws MyCustomException {
		if("Employee".equalsIgnoreCase(entity)) {
			return empRepo.findAll();
			
		}else if(entity.equalsIgnoreCase("Department")){
			return depRepo.findAll();
		}else {
			throw new MyCustomException("Entity you provided is incorrect");
		}
	}

}
