package com.RN.app.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "art")
public class Art {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long artid;
	
	// name of art piece
	@Size(min = 2)
	@Column(name = "name")
	private String name;
	
	@Min(1)
	@Column(name = "cost")
	private double cost;
	
	@ManyToOne
	@JoinColumn(name = "artistid")
	private Artist artistid;
	
	@ManyToMany
	@JoinTable(name = "order_art", joinColumns = @JoinColumn(name = "art_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
	private Set<Orders> orders;
	
	public Art() {
		super();
	}
	
	public Art(String name, double cost, Artist artistid) {
		super();
		this.name = name;
		this.cost = cost;
		this.artistid = artistid;
	}

	public Art(String name, double cost, Artist artistid, Set<Orders> orders) {
		super();
		this.name = name;
		this.cost = cost;
		this.artistid = artistid;
		this.orders = orders;
	}	

	public long getArtid() {
		return artid;
	}

	public void setArtid(long artid) {
		this.artid = artid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Artist getArtistid() {
		return artistid;
	}

	public void setArtistid(Artist artistid) {
		this.artistid = artistid;
	}

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Art [artid=" + artid + ", name=" + name + ", cost=" + cost + ", artistid=" + artistid + ", orders="
				+ orders + "]";
	}
	
	
}
