package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Employ;
import com.example.demo.repo.EmployRepository;
import com.example.demo.service.EmployService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class EmployController {

	@Autowired
	private EmployService employService;
	
	 @PostMapping(value = "/saveemploy")
	 public String saveEmploy(@ModelAttribute Employ employ) {
	     employService.addEmploy(employ);
	     return "redirect:/";   // ⬅ redirect to default mapping
	 }

	
	@GetMapping(value="/newemploy")
	public String newEmploy(@ModelAttribute Employ employ) {
		return "addemploy";
	}
	
	@GetMapping(value="/deleteemploy")
	public String deleteEmploy(HttpServletRequest request) {
		employService.deleteEmploy(Integer.parseInt(request.getParameter("empno")));
		 return "redirect:/";   // ⬅ redirect to default mapping
	}
	
	@GetMapping(value="/updatefinal")
	 public String updateEmploy(@ModelAttribute Employ employ) {
		employService.updateEmploy(employ);
		  return "redirect:/";   // ⬅ redirect to default mapping
	 }
	
	@GetMapping(value="/updateemploy")
	public String updateEmploy(HttpServletRequest request, Model model) {
		int empno = Integer.parseInt(request.getParameter("empno"));
		Employ employ = employService.searchEmploy(empno);
		model.addAttribute("employ",employ);
		return "updateemploy";
	}
	
	@GetMapping(value="/")
	public String show(Model model) {
		List<Employ> employList = employService.showEmploy();
		model.addAttribute("employList",employList);
		return "employshow";
	}
}
