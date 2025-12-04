package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.Faculty;

public class Test {

	public static void main(String[] args) 
	{
		ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
		
		Faculty f1 =(Faculty) ctx.getBean("f1");
		System.out.println(f1);
		
		Faculty f2 =(Faculty) ctx.getBean("f2");
		System.out.println(f2);
		
		Faculty f3 =(Faculty) ctx.getBean("f3");
		System.out.println(f3);

	}

}
