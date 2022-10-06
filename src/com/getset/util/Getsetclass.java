package com.getset.util;

public class Getsetclass {
	private int id;
	private String name;
	private float price;
	private int qty;
	private float totalprice;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public float getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}
	@Override
	public String toString() {
		String ret="\n id = "+this.getId()
		+"\n name = "+this.getName() 
		+"\n price = "+this.getPrice()
		+"\n qty = "+this.getQty()
		+"\n total price = "+this.getTotalprice(); 
		return ret;
		
		
	}

}
