package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.Product;

@Repository
public class ProductdaoImpl implements ProductDaoI 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(Product p) 
	{
		int n = jdbcTemplate.update("insert into product values (?,?,?,?,?)", 
				new Object[] {p.getPid(), p.getPname(), p.getQty(), p.getPrice(), p.getMfgdate()});
		return n > 0;
	}

	@Override
	public List<Product> displayAll() 
	{
		List<Product> plist =  jdbcTemplate.query("select * from product", (rs, n)->{
			Product p = new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setQty(rs.getInt(3));
			p.setPrice(rs.getDouble(4));
			p.setMfgdate(rs.getDate(5).toLocalDate());
			
			return p;
		});
		return plist;
	}

	@Override
	public Product displayByName(String pname) 
	{
		try
		{
			Product p = jdbcTemplate.queryForObject("select * from product where pname=?",
					new Object [] {pname}, BeanPropertyRowMapper.newInstance(Product.class) );
			return p;
		}
		catch(EmptyResultDataAccessException e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public Product displayById(int pid) 
	{
		try
		{
			Product p = jdbcTemplate.queryForObject("select * from product where pid=?",
					new Object [] {pid}, BeanPropertyRowMapper.newInstance(Product.class));
			return p;
		}
		catch(EmptyResultDataAccessException e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean deleteById(int pid) 
	{
		int n = jdbcTemplate.update("delete from product where pid=?",
				new Object [] {pid});
		return n > 0;
	}

	@Override
	public boolean updateById(int pid, int qty, double price) 
	{
		int n = jdbcTemplate.update("update product set qty=?, price=? where pid=?",
				new Object [] {qty, price, pid});
		return n > 0;
	}

	@Override
	public List<Product> displaySortedByPrice() 
	{
		List<Product> plist = jdbcTemplate.query("select * from product order by price",
				(rs, n)->{
					Product p = new Product();
					
					p.setPid(rs.getInt(1));
					p.setPname(rs.getString(2));
					p.setQty(rs.getInt(3));
					p.setPrice(rs.getDouble(4));
					p.setMfgdate(rs.getDate(5).toLocalDate());
					
					return p;
				});
		return plist;
	}
	
	
}
