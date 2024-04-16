package com.demoproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demoproject.entity.Employee;
import com.demoproject.exception.MyCustomException;
import com.demoproject.service.FetchDataService;

@RestController
public class CommonController {
	
	@Autowired
	FetchDataService fetchData;
	
	
	@GetMapping("/getresults")
	public ResponseEntity<?> getResults(@RequestParam String entity) throws MyCustomException{
		List<?> result = fetchData.getResults(entity);
		return new ResponseEntity<>(result,HttpStatus.OK);
		
	}
}
