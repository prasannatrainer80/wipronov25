package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employ;
import com.example.demo.service.EmployService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmployController {

	@Autowired
	public EmployService employService;
	
	@GetMapping(value="/searchEmploy/{id}")
	public Mono<Employ> searchEmploy(@PathVariable int id) {
		return employService.searchEmployDao(id);
	}
	
	@GetMapping(value="/showEmploy")
	public Flux<Employ> showEmploy() {
		return employService.showEmployDao();
	}
}
