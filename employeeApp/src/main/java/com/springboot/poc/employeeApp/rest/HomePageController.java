package com.springboot.poc.employeeApp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageController {
	
	@GetMapping("/")
	public String showHomePage() {
		String home = "<h1>Welcome!</h1>"
				        +"<h2>Employee Rest API</h2>"
				           +"<a href='/api/employees' > Get All Employees </a>";
		
		return home;
	}

}
