package com.RN.app.models;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ArtOrder")
public class ArtOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long artOrderId;
	
	@Column(name = "orderedDate")
	private	LocalDateTime orderedDate;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User userid;
	
	@ManyToMany(mappedBy = "orders")
	private Set<Art> artOrders;
	
	public ArtOrder() {
		super();
	}
	
	public ArtOrder(LocalDateTime orderedDate, User userid) {
		super();
		this.orderedDate = orderedDate;
		this.userid = userid;
	}

	public ArtOrder(long artOrderId, LocalDateTime orderedDate, User userid) {
		super();
		this.artOrderId = artOrderId;
		this.orderedDate = orderedDate;
		this.userid = userid;
	}

	public long getArtOrderId() {
		return artOrderId;
	}

	public void setArtOrderId(long artOrderId) {
		this.artOrderId = artOrderId;
	}

	public LocalDateTime getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(LocalDateTime orderedDate) {
		this.orderedDate = orderedDate;
	}

	public User getUserid() {
		return userid;
	}

	public void setUserid(User userid) {
		this.userid = userid;
	}
	
	
	
}
