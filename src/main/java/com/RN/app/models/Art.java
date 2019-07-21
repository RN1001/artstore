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

@Entity
@Table(name = "art")
public class Art {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long artid;
	
	// name of art piece
	@Column(name = "name")
	private String name;
	
	@Column(name = "cost")
	private double cost;
	
	@ManyToOne
	@JoinColumn(name = "artistid")
	private Artist artistid;
	
	@ManyToMany
	@JoinTable(name = "order_art", joinColumns = @JoinColumn(name = "art_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
	private Set<ArtOrder> orders;
	
}
