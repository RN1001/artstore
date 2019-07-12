package com.RN.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.NonNull;



@Entity
public class User {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private @NonNull long id;
	private @NonNull String username;
	private @NonNull String password;
	private long orderId;
	
	public User() {
		
	}
	
	public User(String username, String password, long id) {
		this.username = username;
		this.password = password;
		this.orderId = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", orderId=" + orderId + "]";
	}
	
	
	
	
}
