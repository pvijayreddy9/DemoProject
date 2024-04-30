package com.demoproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping("/save") 	
	public String save() { 
		
		return "Success" ;
	}	
	
}
