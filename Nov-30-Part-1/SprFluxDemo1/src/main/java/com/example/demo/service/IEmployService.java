package com.example.demo.service;

import com.example.demo.model.Employ;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IEmployService {
	Flux<Employ> showEmployDao();
	Mono<Employ> searchEmployDao(int empno);
}
