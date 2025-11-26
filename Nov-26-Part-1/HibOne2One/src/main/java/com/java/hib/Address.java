package com.java.hib;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity  
@Table(name="addresswipro2")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {    
      
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO)  
private int addressId;    
private String addressLine1,city,state,country;    
private int pincode;    
//  
//@OneToOne(targetEntity=Employee.class)  
//private Employee employee;  
}