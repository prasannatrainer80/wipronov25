package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

	@GetMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@GetMapping(value="/showNames")
	public String showNames(Model model) {
		List<String> names = Arrays.asList("Sanjana","Suchero","Vatsal","Satya","Swapna");
		model.addAttribute("names",names);
		return "show";
	}
	
	@GetMapping(value="/loginvalid")
	public String loginValid(HttpServletRequest request, Model model ) {
		String user = request.getParameter("userName");
		String pwd = request.getParameter("passCode");
		if (user.equals("Wipro") && pwd.equals("Wipro")) {
			return "menu";
		}
		model.addAttribute("error","Invalid Credentials...");
		return "login";
	}
	
	@GetMapping(value="/")
	public String hello() {
		return "hello";
	}
	
	@GetMapping(value="/suchero")
	public String suchero() {
		return "suchero";
	}
	
	@GetMapping(value="/sanjana")
	public String sanjana() {
		return "sanjana";
	}
}
