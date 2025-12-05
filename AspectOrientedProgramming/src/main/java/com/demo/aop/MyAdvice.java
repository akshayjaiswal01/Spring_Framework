package com.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice 
{
	@Before("execution (* com.demo.beans.*.*(..))")
	public void beforeAdvice()
	{
		System.out.println("In before advice");
	}
	
	@After("execution (* com.demo.beans.*.*(..))")
	public void afterAdvice()
	{
		System.out.println("In after advice");
	}
	
	@Around("execution (* com.demo.beans.*.*(..))")
	public Object aroundAdvice(ProceedingJoinPoint jpoint) throws Throwable 
	{
		System.out.println("In aroundAdvice() before funtion call");
		Object ob = jpoint.proceed();
		System.out.println("In aroundAdvice() after funtion call");
		return ob;
		
	}
}
