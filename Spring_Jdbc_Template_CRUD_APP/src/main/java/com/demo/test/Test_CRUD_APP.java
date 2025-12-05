package com.demo.test;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.Product;

public class Test_CRUD_APP {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springconfig.xml");
		Product pservice;
		
		int choice = 0;
		
		do
		{
			System.out.println("1. Add new Product \n"
							 + "2. Display All \n"
							 + "3. Display by Category \n"
							 + "4. Display by ID \n"
							 + "5. Delete by ID \n"
							 + "6. Modify by ID \n"
							 + "7. Arrange in sorted order \n"
							 + "8. Exit \n");
			
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			
			switch(choice)
			{
				case 1 ->
				{
					boolean status = pservice.addNewProduct();
					if(status)
					{
						System.out.println("Product Added successfully...");
					}
					else
					{
						System.out.println("Failed to add");
					}
				}
			}
			
		}
		while(choice != 8);
	}

}
