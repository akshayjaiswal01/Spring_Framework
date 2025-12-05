package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.MyUser;

public class Test {

	public static void main(String[] args) 
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springconfig.xml");
		MyUser u =  (MyUser) ctx.getBean("myUser");
		System.out.println(u);
		
		u.m1();
		u.m2();

	}

}
