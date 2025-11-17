package com.java.spr;

import java.util.List;

public class Vendor {

	private int vid;
	private String vendorName;
	private List<Customer> customers;
	public Vendor(int vid, String vendorName, List<Customer> customers) {
		super();
		this.vid = vid;
		this.vendorName = vendorName;
		this.customers = customers;
	}
	
	public void showInfo() {
		System.out.println("Vendor Id  " +vid + " Vendor Name " +vendorName);
		for (Customer customer : customers) {
			System.out.println(customer);
		}
	}
}
