package com.demo.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;


@Configuration
public class MyConfiguration 
{
	@Bean
	public  ResourceBundleMessageSource getMessageSource()
	{
		 ResourceBundleMessageSource rbm =new  ResourceBundleMessageSource();
		 rbm.setBasename("messages");
		 
		return rbm;
		 
		
	}
	

}
