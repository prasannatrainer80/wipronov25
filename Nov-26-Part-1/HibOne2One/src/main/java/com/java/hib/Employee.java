package com.java.hib;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity  
@Table(name="employeewipro2")  
@Getter
@Setter 
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO)  
    @PrimaryKeyJoinColumn  
    private int employeeId;    
    private String name,email;    
    @OneToOne(targetEntity=Address.class,cascade=CascadeType.ALL)  
    private Address address;  
}
