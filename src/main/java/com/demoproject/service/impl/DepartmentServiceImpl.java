package com.demoproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoproject.dao.DepartmentRepository;
import com.demoproject.dto.DepartmentDto;
import com.demoproject.entity.Department;
import com.demoproject.service.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	DepartmentRepository depRepo;
	@Override
	public Department saveEmployee(DepartmentDto depDto) {
		Department dep = new Department(depDto);
		return depRepo.save(dep);
	}
	@Override
	public List<Department> findAllDepartments() {
		
		return depRepo.findAll();
	}
	@Override
	public Department findById(Long depId) {
		
		return depRepo.findById(depId).get();
	}

}
