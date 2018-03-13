package com.ufcg.si1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class SaleItem implements Serializable {
	
	@Id
    @GeneratedValue
	private long id;

	@ManyToOne
	private Product product;

	private int amount;

	private double price;
	
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product Product) {
		this.product = Product;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}
	
	public void setPrice(double preco) {
		this.price = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		SaleItem other = (SaleItem) obj;
		if (id != other.id)
			return false;
		return true;
	}	
	
}
