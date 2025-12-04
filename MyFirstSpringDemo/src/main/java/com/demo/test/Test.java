package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.HelloWorld;
import com.demo.beans.MyUser;

public class Test {

	public static void main(String[] args) 
	{
		ApplicationContext ctx= new ClassPathXmlApplicationContext("springconfig.xml");
		
		HelloWorld hw =(HelloWorld) ctx.getBean("hw");
		System.out.println(hw.sayHello());
		
		MyUser u1=(MyUser) ctx.getBean("u1");
		System.out.println(u1);
		
		MyUser u22=(MyUser) ctx.getBean("u2");
		System.out.println(u22);

	}

}
