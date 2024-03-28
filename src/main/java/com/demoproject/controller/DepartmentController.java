package com.demoproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demoproject.dto.DepartmentDto;
import com.demoproject.entity.Department;
import com.demoproject.service.DepartmentService;

@RestController
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;
	
	@PostMapping("/saveDepartment")
	public ResponseEntity<Department> save(@RequestBody DepartmentDto department){
		//DepartmentDto depdto = new DepartmentDto(dep);
		Department dep = departmentService.saveEmployee(department);
		return new ResponseEntity<>(dep, HttpStatus.CREATED);
	}
	
	@GetMapping("/getalldepartments") 
	public ResponseEntity<List<Department>> getDepartments() { 
	  List<Department> depList = departmentService.findAllDepartments(); 
	  return new ResponseEntity<>(depList,HttpStatus.OK); 
	}

}
