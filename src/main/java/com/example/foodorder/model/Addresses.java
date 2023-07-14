package com.example.foodorder.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Addresses implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	Long aid;
	String address;
	
	@ManyToOne
	FoodAppUser user_id;

	public Long getAid() {
		return aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
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
