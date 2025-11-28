package com.example.demo;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Employ;
import com.example.demo.model.Employee;

@RestController
public class TestController {

	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/dbAdd")
	public String dbAdd(@RequestBody Employ employ) {
		// Make the POST request
		String url = "http://SBEMPLOYCRUD/employ/addEmploy";
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
     // Create an HttpEntity
        HttpEntity<Employ> entity = new HttpEntity<>(employ, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, 
        		HttpMethod.POST, entity, String.class);
		return response.getBody();
	}

	
	@GetMapping(value="/search/{id}")
	public Employee findById(@PathVariable int id)
	{
		Employee employee = restTemplate.getForObject("http://EUREKACLIENT/employee/find/"+id, Employee.class);
		return employee;
	}
	
	@GetMapping("/db")
	public Employ[] showDbEmploy() {
		Employ[] employs = restTemplate.getForObject("http://SBEMPLOYCRUD/employ/showEmploy", Employ[].class);
		return employs;
	}
	
	
	@GetMapping("/dbsearch/{id}")
	public Employ searchDbEmploy(@PathVariable int id) {
		Employ employs = restTemplate.getForObject("http://SBEMPLOYCRUD/employ/searchEmploy/"+id, Employ.class);
		return employs;
	}
	

	
	@GetMapping(value="/inter")
	public Employee[] showEmploy() {
		Employee[] employs = restTemplate.getForObject("http://EUREKACLIENT/employee/findall", Employee[].class);
		return employs;

	}
	
	

}
