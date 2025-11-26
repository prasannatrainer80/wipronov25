package com.java.hib;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity  
@Table(name="wiproanswer")  
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter 
@ToString
public class Answer {   

@Id  
@GeneratedValue(strategy=GenerationType.TABLE)  

private int id;    
private String answername;    
private String postedBy;  
  
}    