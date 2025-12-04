package com.demo.beans;

import java.util.List;

public class Order 
{
	private int orderId;
	private String cname;
	List<Product> plist;
	public Order() {
		super();
	}
	public Order(int orderId, String cname, List<Product> plist) {
		super();
		this.orderId = orderId;
		this.cname = cname;
		this.plist = plist;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public List<Product> getPlist() {
		return plist;
	}
	public void setPlist(List<Product> plist) {
		this.plist = plist;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", cname=" + cname + ", plist=" + plist + "]";
	}
	
	
}
