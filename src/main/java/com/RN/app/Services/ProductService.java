package com.RN.app.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RN.app.models.Art;
import com.RN.app.models.Artist;
import com.RN.app.repositories.ArtRepository;
import com.RN.app.repositories.ArtistRepository;

@Service
public class ProductService {
	
	private ArtistRepository artistRepository;
	private ArtRepository artRepository;
	
	@Autowired
	public ProductService(ArtistRepository artistRepository, ArtRepository artRepository) {
		// TODO Auto-generated constructor stub
		this.artistRepository = artistRepository;
		this.artRepository = artRepository;
	}
	
	public Artist saveArtist(Artist artist) {
		return this.artistRepository.save(artist);
	}
	
	public Art saveArt(Art art) {
		return this.artRepository.save(art);
	}
	
	public Iterable<Artist> findAllArtists() {
		return this.artistRepository.findAll();
	}
	
}
