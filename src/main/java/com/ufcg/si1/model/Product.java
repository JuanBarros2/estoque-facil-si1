package com.ufcg.si1.model;

import javax.persistence.*;

@Entity
public class Product {
	@Id @GeneratedValue
	private Long id;
	private String name;
	private Double price;
	private String barcode;
	private String manufacturer;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Category category;

	public Product() {
	}

	public Product(String name, Double price, String barcode, String manufacturer,
				   String category) {
		this.name = name;
		this.price = price;
		this.barcode = barcode;
		this.manufacturer = manufacturer;
		this.category = new Category(category);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Category getCategory() {
		return this.category;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
