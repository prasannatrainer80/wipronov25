package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value="/employee")
@RestController
public class EmployeeController {

	@GetMapping(value="/company")
	public String company() {
		return "Company is Wipro...";
	}
	
	@GetMapping(value="/topic")
	public String topic() {
		return "Java Training...";
	}
}
