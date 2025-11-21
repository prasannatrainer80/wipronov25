package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employ;
import com.example.demo.repo.EmployRepository;

@Service
public class EmployService {

	@Autowired
	private EmployRepository employRepository;
	
	public List<Employ> showEmploy() {
		return employRepository.findAll();
	}
	
	public String deleteEmploy(int empno) {
		 if (!employRepository.existsById(empno)) {
	            throw new NoSuchElementException("Employ No not found");
	        }
		 employRepository.deleteById(empno);
		return "Employ Record Deleted...";
	}
	public String updateEmploy(Employ employ) {
		employRepository.save(employ);
		return "Employ Record Updated...";
	}
	
	public String addEmploy(Employ employ) {
		employRepository.save(employ);
		return "Employ Record Inserted...";
	}
	
	public Optional<Employ> searchEmploy(int empno) {
	    return employRepository.findById(empno);
	}

}
