package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value="/consumer")
@RestController
public class ConsumerController {

	@GetMapping(value="/showconsumer")
	public String showData() {
		return "From Great Learning...Training Academy...";
	}
	
	@GetMapping(value="/location")
	public String location() {
		return "It is From Bangalore...";
	}
}
