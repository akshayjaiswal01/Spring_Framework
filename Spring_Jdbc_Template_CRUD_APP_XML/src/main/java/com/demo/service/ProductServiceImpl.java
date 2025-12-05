package com.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Product;
import com.demo.dao.ProductDaoI;
import com.demo.dao.ProductdaoImpl;

@Service
public class ProductServiceImpl implements ProductServiceI 
{
	@Autowired
	ProductDaoI pdao;
	
	public ProductServiceImpl()
	{
		pdao = new ProductdaoImpl();
	}

	@Override
	public boolean addNewProduct() 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Product ID: ");
		int pid = sc.nextInt();
		
		sc.nextLine();
		System.out.println("Enter Product Name: ");
		String pname = sc.next();
		
		System.out.println("Enter Product Quantity: ");
		int qty = sc.nextInt();
		
		System.out.println("Enter Product price: ");
		double price = sc.nextDouble();
		
		System.out.println("Enter Product mfg date (dd/mm/yyyyy): ");
		String date = sc.next();
		LocalDate ldt = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		Product p = new Product(pid, pname, qty, price, ldt);
		
		return pdao.save(p);
	}

	@Override
	public List<Product> displayAll() 
	{
		return pdao.displayAll();
	}

	@Override
	public Product displayByName(String pname) 
	{
		return pdao.displayByName(pname);
	}

	@Override
	public Product displayById(int pid) 
	{
		return pdao.displayById(pid);
	}

	@Override
	public boolean deleteById(int pid) 
	{
		return pdao.deleteById(pid);
	}

	@Override
	public boolean updateById(int pid, int qty, double price) 
	{
		return pdao.updateById(pid, qty, price);
	}

	@Override
	public List<Product> displaySortedByPrice() 
	{
		return pdao.displaySortedByPrice();
	}
	
	
}
