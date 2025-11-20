package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CalculationController {

	@GetMapping(value="/calc")
	public String calcInput() {
		return "calc";
	}
	
	@GetMapping(value="/calcresult")
	public String calcResult(HttpServletRequest request, Model model) {
		int firstNo, secondNo;
		firstNo = Integer.parseInt(request.getParameter("firstNo"));
		secondNo = Integer.parseInt(request.getParameter("secondNo"));
		int sum = firstNo + secondNo;
		int sub = firstNo - secondNo;
		int mult = firstNo * secondNo;
		model.addAttribute("firstNo",firstNo);
		model.addAttribute("secondNo",secondNo);
		model.addAttribute("sum", sum);
		model.addAttribute("sub",sub);
		model.addAttribute("mult",mult);
		return "calcresult";
	}
}
