package com.example.foodorder.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "OrderHistory")
public class OrderHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long oid;

	@OneToMany
	List<Category> cat_id;

	int total;
	int quantity;
	LocalDate order_date;
	String status;
	String address;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false, updatable = false, insertable = false)
	FoodAppUser user_id;

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public List<Category> getCat_id() {
		return cat_id;
	}

	public void setCat_id(List<Category> cat_id) {
		this.cat_id = cat_id;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDate getOrder_date() {
		return order_date;
	}

	public void setOrder_date(LocalDate order_date) {
		this.order_date = order_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public FoodAppUser getUser_id() {
		return user_id;
	}

	public void setUser_id(FoodAppUser user_id) {
		this.user_id = user_id;
	}

}
