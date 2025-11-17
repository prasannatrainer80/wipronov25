package com.java.spr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainExample {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/hexaware/conex/vendor.xml");
		Vendor vendor = (Vendor)ctx.getBean("vendor");
		vendor.showInfo();
	}
}
