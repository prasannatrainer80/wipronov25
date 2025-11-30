package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employ;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployService implements IEmployService {

	static Flux<Employ> employService;
	static {
		Employ e1 = new Employ(1, "Srinath", 994234);
		Employ e2 = new Employ(2, "Karthik", 98322);
		Employ e3 = new Employ(3, "Sunny", 88322);
		Employ e4 = new Employ(4, "Rushikesh", 77333);
		employService = Flux.just(e1, e2, e3,e4);
	}
	
	@Override
	public Flux<Employ> showEmployDao() {
		// TODO Auto-generated method stub
		return employService;
	}

	@Override
	public Mono<Employ> searchEmployDao(int empno) {
	    return employService
	            .filter(e -> e.getEmpno() == empno)  // Filter matching employ
	            .next();                             // Convert Flux → Mono (first element)
	}

}
