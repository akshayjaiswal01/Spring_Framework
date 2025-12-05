package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDaoI {

	boolean save(Product p);

	List<Product> displayAll();

	Product displayByName(String pname);

	Product displayById(int pid);

	boolean deleteById(int pid);

	boolean updateById(int pid, int qty, double price);

	List<Product> displaySortedByPrice();

}
