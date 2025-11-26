package com.java.hib;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class AddQuestionMain {
	public static void main(String[] args) {
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		Question question1 = new Question();
//		question1.setId(1);
		question1.setQname("What is Java");
		
		Question question2 = new Question();
//		question2.setId(2);
		question2.setQname("What is Hibernate");
		
		Answer ans1 = new Answer();
//		ans1.setId(1);
		ans1.setPostedBy("Vatsal");
		ans1.setAnswername("Java is High Level Language...Platform Indepenent...Compiled and Interprted");
		
		Answer ans2 = new Answer();
//		ans2.setId(2);
		ans2.setPostedBy("Sanjana");
		ans2.setAnswername("Java is Object Oriented Programming Language...Write Once and Run anywhere");
		
		Answer ans3 = new Answer();
//		ans3.setId(3);
		ans3.setPostedBy("Satya");
		ans3.setAnswername("Hibernate is ORM framework as maps classes to tables");
		
		Answer ans4 = new Answer();
//		ans4.setId(4);
		ans4.setPostedBy("Bhavana");
		ans4.setAnswername("It is Open source framework in java as makes db operations easier works on POJO classes");
		
		List<Answer> list1 = Arrays.asList(ans1, ans2);
		List<Answer> list2 = Arrays.asList(ans3, ans4);
		
		question1.setAnswers(list1);
		question2.setAnswers(list2);
		
		session.save(question1);
		session.save(question2);
		
		trans.commit();
		System.out.println("Questions and Answers are Stored...");
	}
}
