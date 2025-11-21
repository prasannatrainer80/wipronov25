package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employ;
import com.example.demo.service.EmployService;

@RestController
public class EmployController {

    @Autowired
    private EmployService employService;

    // ---------------- SHOW ALL ------------------
    @GetMapping("/showEmploy")
    public ResponseEntity<List<Employ>> showEmploy() {
        List<Employ> list = employService.showEmploy();
        return ResponseEntity.ok(list);  // 200 OK
    }

    // ---------------- SEARCH ---------------------
    @GetMapping("/searchEmploy/{empno}")
    public ResponseEntity<?> searchEmploy(@PathVariable int empno) {

        Optional<Employ> emp = employService.searchEmploy(empno);

        if (emp.isPresent()) {
            return ResponseEntity.ok(emp.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body("Employ Not Found");
    }


    // ---------------- DELETE ---------------------
    @DeleteMapping("/deleteEmploy/{empno}")
    public ResponseEntity<?> deleteEmploy(@PathVariable int empno) {

        String result = employService.deleteEmploy(empno);

        if (result.equalsIgnoreCase("Employ Not Found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }

        return ResponseEntity.ok(result); // 200 OK
    }

    // ---------------- UPDATE ---------------------
    @PutMapping("/updateEmploy")
    public ResponseEntity<?> updateEmploy(@RequestBody Employ employ) {

        String result = employService.updateEmploy(employ);

        if (result.equalsIgnoreCase("Employ Not Found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }

        return ResponseEntity.ok(result); // 200 OK
    }

    // ---------------- ADD ------------------------
    @PostMapping("/addEmploy")
    public ResponseEntity<?> addEmploy(@RequestBody Employ employ) {

        String result = employService.addEmploy(employ);

        if (result.equalsIgnoreCase("Employ Already Exists")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(result); // 201 CREATED
    }
}
