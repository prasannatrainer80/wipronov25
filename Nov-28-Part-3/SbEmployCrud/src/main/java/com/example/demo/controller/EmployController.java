package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employ;
import com.example.demo.service.EmployService;

@RestController
@RequestMapping(value="/employ")
public class EmployController {

	@Autowired
	private EmployService employService;
	
	@GetMapping(value="/showEmploy")
	public List<Employ> showEmploy() {
		return employService.showEmploy();
	}
	
	@GetMapping(value="/searchEmploy/{id}")
	public Employ searchEmploy(@PathVariable int id) {
		return employService.searchEmploy(id);
	}
	
	@PostMapping(value="/addEmploy")
	public void addEmploy(@RequestBody Employ employ) {
		employService.addEmploy(employ);
	}
	
	@DeleteMapping(value="/deleteEmploy/{id}")
	public void deleteEmploy(@PathVariable int id) {
		employService.deleteEmploy(id);
	}
	
	@PutMapping(value="/updateEmploy")
	public void updateEmploy(@RequestBody Employ employ) {
		employService.updateEmploy(employ);
	}
}
