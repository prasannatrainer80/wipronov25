package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.db.Employ;
import com.example.demo.repository.EmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Flux<Employ> showEmployee() {
		return employeeRepository.findAll();
	}
	
	public Mono<Employ> searchEmployee(int id) {
		return employeeRepository.findById(id);
	}
	
	public Mono<Employ> saveEmployee(Employ employee) {
		return employeeRepository.save(employee);
	}
	
	  public Mono<Void> deleteById(int id) {
		    return employeeRepository.deleteById(id);
		  }
}
