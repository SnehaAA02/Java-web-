package com.bean;

public class Product {
	private int productId;
	private String name;
	private double price;
	private int quantityAvailable;
	public Product(int productId, String name, double price, int quantityAvailable) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.quantityAvailable = quantityAvailable;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantityAvailable() {
		return quantityAvailable;
	}
	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}
	
	
}
