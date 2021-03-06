package com.ufcg.si1.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
public class Sale {
	@Id
    @GeneratedValue
	private long id;

	@OneToMany(cascade= CascadeType.ALL, fetch=FetchType.EAGER)
    private List<SaleItem> items;

	private String date;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<SaleItem> getItems() {
		return items;
	}

	public void setItems(List<SaleItem> items) {
		this.items = items;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getTotalPrice(){
		Double total = 0D;
		for(SaleItem item: items){
			total += item.getPrice() * item.getAmount();
		}
		return total;
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
		Sale other = (Sale) obj;
		if (id != other.id)
			return false;
		return true;
	}
    
    
}
