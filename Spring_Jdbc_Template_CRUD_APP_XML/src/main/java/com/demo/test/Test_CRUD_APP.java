package com.demo.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.Product;
import com.demo.service.ProductServiceI;

public class Test_CRUD_APP {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springconfig.xml");
		ProductServiceI pservice = (ProductServiceI) ctx.getBean("productServiceImpl");
		
		int choice = 0;
		
		do
		{
			System.out.println("1. Add new Product \n"
							 + "2. Display All \n"
							 + "3. Display by Name \n"
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
				
				case 2->
				{
					List<Product> plist =  pservice.displayAll();
					plist.forEach(System.out::println);
				}
				
				case 3->
				{
					System.out.println("Enter Product Name: ");
					String pname = sc.next();
					
					Product p = pservice.displayByName(pname);
					if(p != null)
					{
						System.out.println(p);
					}
					else
					{
						System.out.println("Not found");
					}
				}
				
				case 4->
				{
					System.out.println("Enter Product ID: ");
					int pid = sc.nextInt();
					
					Product p = pservice.displayById(pid);
					if(p != null)
					{
						System.out.println(p);
					}
					else
					{
						System.out.println("Not found");
					}
				}
				
				case 5 ->
				{
					System.out.println("Enter Product ID: ");
					int pid = sc.nextInt();
					
					boolean status = pservice.deleteById(pid);
					if(status)
					{
						System.out.println("Product delete successfully");
					}
					else
					{
						System.out.println("Not found");
					}
				}
				
				case 6 ->
				{
					System.out.println("Enter Product ID: ");
					int pid = sc.nextInt();
					
					System.out.println("Enter updated quantity: ");
					int qty = sc.nextInt();
					
					System.out.println("Enter updated price: ");
					double price = sc.nextDouble();
					
					boolean status = pservice.updateById(pid, qty, price);
					if(status)
					{
						System.out.println("Product updated successfully");
					}
					else
					{
						System.out.println("Not found");
					}
				}
				
				case 7 ->
				{
					List<Product> plist = pservice.displaySortedByPrice();
					plist.forEach(System.out::println);
				}
				
				case 8->
				{
					sc.close();
					System.out.println("Thank you...");
				}
				
			}
			
		}
		while(choice != 8);
	}

}
