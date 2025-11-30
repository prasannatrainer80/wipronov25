package com.example.demo.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.db.Employ;

@Repository
public interface EmployeeRepository extends R2dbcRepository<Employ, Integer>{  

}
