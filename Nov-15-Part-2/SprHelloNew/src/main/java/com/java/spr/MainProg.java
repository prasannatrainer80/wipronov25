package com.java.spr;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainProg {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/spr/Hello.xml");
		HelloImpl impl = null;
		Date date = new Date();
		int hr = date.getHours();
		if (hr <12) {
			impl = (HelloImpl)ctx.getBean("greet1");
		} else if (hr >=12 && hr < 16) {
			impl = (HelloImpl)ctx.getBean("greet2");
		} else if (hr > 16) {
			impl = (HelloImpl)ctx.getBean("greet3");
		}
		
		System.out.println(impl.sayHello("Satya"));
	}
}
