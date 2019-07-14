package com.RN.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.NonNull;



@Entity
public class User {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@NonNull
	private long id;
	
	@Size(min=5, max=30)
	@NonNull
	private String username;
	
	@Size(min=8)
	@NonNull
	private String password;
	
	@Email
	@NonNull
	private String email;
	
	// must be changed to an orders class, collection class with a manytoone
	private long orderId;
	
	public User() {
		
	}
	
	public User(String username, String password, String email, long orderId) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.orderId = orderId;
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", orderId=" + orderId + "]";
	}

	
	
	
	
	
}
