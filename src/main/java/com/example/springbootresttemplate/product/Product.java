package com.example.springbootresttemplate.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
public class Product {

	@Id
	@GeneratedValue
	private int id;
	private String name;

	private int quantity;

	public double price;

	public Product() {
		super();
	}

	public Product(String name, int quantity, double price) {

		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

}
