package com.demoproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demoproject.dto.DepartmentDto;
import com.demoproject.entity.Department;
import com.demoproject.entity.Employee;

@Service
public interface DepartmentService {

	Department saveEmployee(DepartmentDto dep);

	List<Department> findAllDepartments();
	
	public Department findById(Long depId);
	
	

}
