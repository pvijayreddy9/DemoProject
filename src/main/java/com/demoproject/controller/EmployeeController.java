package com.demoproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demoproject.dto.EmployeeDto;
import com.demoproject.entity.Employee;
import com.demoproject.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	
	@GetMapping("/getallemployee") 
	public ResponseEntity<List<Employee>> getEmployees() { 
	  List<Employee> emplList = empService.findAllEmployees(); 
	  return new ResponseEntity<>(emplList,HttpStatus.OK); 
	}
	
	@GetMapping("/getemployee") 
	public ResponseEntity<Employee> getEmployeeById(@RequestParam Long empId) { 
		Employee emp = empService.findEmployeeById(empId); 
		return new ResponseEntity<>(emp,HttpStatus.OK); 
	}
	
	@PostMapping("/saveemployee") 
	public ResponseEntity<Employee> saveEmployee(@RequestBody EmployeeDto emp) { 
		Employee employee = empService.saveEmployee(emp); 
		return new ResponseEntity<>(employee,HttpStatus.OK); 
	}
}
