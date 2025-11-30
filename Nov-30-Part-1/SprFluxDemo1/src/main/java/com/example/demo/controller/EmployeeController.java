package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.Employ;
import com.example.demo.service.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value="/showEmployee")
	public Flux<Employ> showEmployee() {
		return employeeService.showEmployee();
	}
	
	@GetMapping(value="/searchEmployee/{id}")
	public Mono<Employ> searchEmployee(@PathVariable int id) {
		return employeeService.searchEmployee(id);
	}
	
	@PostMapping(value="/addEmployee")
	public Mono<Employ> saveEmployee(@RequestBody Employ employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@DeleteMapping(value="/deleteEmployee/{id}")
	public Mono<Void> deleteEmployee(@PathVariable int id) {
		return employeeService.deleteById(id);
	}
}
