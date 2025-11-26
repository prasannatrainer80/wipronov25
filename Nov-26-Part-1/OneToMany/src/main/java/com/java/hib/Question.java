package com.java.hib;

import java.util.List;

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

@Entity  
@Table(name="wiproquestion")  
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Question {    
  
@Id   
@GeneratedValue(strategy=GenerationType.TABLE)  
private int id;    
private String qname;    
  
@OneToMany(cascade = CascadeType.ALL)  
@JoinColumn(name="qid")  
@OrderColumn(name="type")  
private List<Answer> answers;  
      
}