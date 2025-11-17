package com.java.spr;

public class Customer {

	private String customerName;
	private double billAmount;
	public Customer(String customerName, double billAmount) {
		super();
		this.customerName = customerName;
		this.billAmount = billAmount;
	}
	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", billAmount=" + billAmount + "]";
	}
	
	
}
