package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Employee;

@RestController
public class TestController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(value="/search/{id}")
	public Employee findById(@PathVariable int id)
	{
		Employee employee = restTemplate.getForObject("http://EUREKACLIENT/employee/find/"+id, Employee.class);
		return employee;
	}
	
	@GetMapping(value="/inter")
	public Employee[] showEmploy() {
		Employee[] employs = restTemplate.getForObject("http://EUREKACLIENT/employee/findall", Employee[].class);
		return employs;

	}

}
