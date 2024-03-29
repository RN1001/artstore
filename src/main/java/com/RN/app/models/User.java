package com.RN.app.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.NonNull;



@Entity
@Table(name = "User")
public class User {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@NonNull
	@Column(name="userid")
	private long userid;
	
	@Size(min=5, max=30)
	@NonNull
	@Column(name="username")
	private String username;
	
	@Size(min=8)
	@NonNull
	@Column(name="password")
	private String password;
	
	@Email
	@NonNull
	@Column(name="email")
	private String email;
	
	// must be changed to an orders class, collection class with a manytoone
	@OneToMany(mappedBy = "userid")
	private Set<Orders> orders;
	
	public User() {
		
	}
	
	public User(String username, String password, String email, Set<Orders> orders) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.orders = orders;
	}

	public long getId() {
		return userid;
	}

	public void setId(long userid) {
		this.userid = userid;
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

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "User [id=" + userid + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", orders=" + orders + "]";
	}

	
	
	
	
	
}
