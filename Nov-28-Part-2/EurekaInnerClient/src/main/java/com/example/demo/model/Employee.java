package com.example.demo.model;

public class Employee {
 	
	private Long employeeId;
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	private String name;
	private String practiceArea;
	private String designation;
	private String companyInfo;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPracticeArea() {
		return practiceArea;
	}
	public void setPracticeArea(String practiceArea) {
		this.practiceArea = practiceArea;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getCompanyInfo() {
		return companyInfo;
	}
	public void setCompanyInfo(String companyInfo) {
		this.companyInfo = companyInfo;
	}
	public Employee(String name, String practiceArea, String designation, String companyInfo) {
		super();
		this.name = name;
		this.practiceArea = practiceArea;
		this.designation = designation;
		this.companyInfo = companyInfo;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", practiceArea=" + practiceArea + ", designation=" + designation
				+ ", companyInfo=" + companyInfo + "]";
	}
	   
	   
}
