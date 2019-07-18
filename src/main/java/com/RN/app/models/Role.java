package com.RN.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="role_id")
	private long id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="roleStatus")
	private String roleStatus;
	
	public Role() {
		super();
	}
		
	public Role(String username, String roleStatus) {
		super();
		this.username = username;
		this.roleStatus = roleStatus;
	}

	public Role(long id, String username, String roleStatus) {
		super();
		this.id = id;
		this.username = username;
		this.roleStatus = roleStatus;
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
	
	public String getRoleStatus() {
		return roleStatus;
	}
	
	public void setRoleStatus(String roleStatus) {
		this.roleStatus = roleStatus;
	}
	
	@Override
	public String toString() {
		return "Roles [id=" + id + ", username=" + username + ", roleStatus=" + roleStatus + "]";
	}
	
	
	
}
