package com.RN.app.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "artist")
public class Artist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long artistId;
	
	@Size(min = 2)
	@Column(name = "firstname")
	private String firstname;
	
	@Size(min = 2)
	@Column(name = "lastname")
	private String lastname;
	
	@OneToMany(mappedBy = "artistid")
	private Set<Art> art;
	
	public Artist() {
		
	}

	public Artist(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Artist(long artistId, String firstname, String lastname, Set<Art> art) {
		super();
		this.artistId = artistId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.art = art;
	}

	public long getArtistId() {
		return artistId;
	}

	public void setArtistId(long artistId) {
		this.artistId = artistId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Set<Art> getArt() {
		return art;
	}

	public void setArt(Set<Art> art) {
		this.art = art;
	}

	@Override
	public String toString() {
		return "Artist [artistId=" + artistId + ", firstname=" + firstname + ", lastname=" + lastname + ", art=" + art
				+ "]";
	}
	
	
	
}
	
