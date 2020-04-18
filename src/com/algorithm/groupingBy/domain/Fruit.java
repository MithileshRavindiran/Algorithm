package com.algorithm.groupingBy.domain;

import java.math.BigDecimal;

public class Fruit {
	public Fruit(int id, String name, FruitType type, int quantity, BigDecimal price, int likes) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.quantity = quantity;
		this.price = price;
		this.likes = likes;
	}
	private int id;
	private String name;
	private FruitType type;
	private int quantity;
	private BigDecimal price;
	private int likes;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	public Double getTotal() {
		return this.quantity * this.price.doubleValue();
	}
	
	public String getTypeLikes() {
		return this.type.name() + this.likes;
	}

	public FruitType getType() {
		return type;
	}

	public void setType(FruitType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", type=" + type + ", quantity=" + quantity + ", price=" + price
				+ ", likes=" + likes + "]";
	}

}
