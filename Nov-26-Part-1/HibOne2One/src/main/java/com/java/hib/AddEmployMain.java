package com.java.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class AddEmployMain {
	public static void main(String[] args) {
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session =sf.openSession();
		Transaction t=session.beginTransaction();
		Employee emp1 = new Employee();
		emp1.setName("Krish Sahu");
		emp1.setEmail("krish@gmail.com");
		
		Address address1 = new Address();
		address1.setCity("PUne");
		address1.setState("MH");
		address1.setAddressLine1("TRT-81");
		address1.setPincode(8482345);
		address1.setCountry("India");
		emp1.setAddress(address1);
//		address1.setEmployee(emp1);
		session.save(emp1);
		t.commit();
		System.out.println("*** Tables Created ***");

	}
}
