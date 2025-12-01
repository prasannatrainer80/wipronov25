package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping(value="/admin")
public class AdminController {

    @GetMapping(value="/")
    public String home() {
    	return "home";
    }
    
    @GetMapping(value="/adminPage")
    public String adminPage() {
    	return "adminPage";
    }
    
    @GetMapping(value="/loginPage")
    public String login() {
    	return "login";
    }
   
}