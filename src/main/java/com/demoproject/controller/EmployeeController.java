package com.demoproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demoproject.dto.EmployeeDto;
import com.demoproject.entity.Employee;
import com.demoproject.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	
	@GetMapping("/getallemployee") 
	public ResponseEntity<List<EmployeeDto>> getEmployees() { 
	  
	  return new ResponseEntity<>(empService.findAllEmployees(),HttpStatus.OK); 
	}
	
	@GetMapping("/getemployee") 
	public ResponseEntity<EmployeeDto> getEmployeeById(@RequestParam Long empId) { 
		 
		return new ResponseEntity<>(empService.findEmployeeById(empId),HttpStatus.OK); 
	}
	
	@PostMapping("/saveemployee") 
	public ResponseEntity<EmployeeDto> saveEmployee(@Valid @RequestBody EmployeeDto emp) { 
		
		return new ResponseEntity<>(empService.saveEmployee(emp),HttpStatus.OK); 
	}
	@DeleteMapping("/deleteemployee") 
	public ResponseEntity<String> deleteEmployee(@RequestParam Long emp) { 		  
		return new ResponseEntity<>(empService.deleteEmployee(emp),HttpStatus.OK); 
	}
}
