package com.RN.app.misc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.RN.app.models.Artist;
import com.RN.app.repositories.ArtistRepository;

public class ArtistsDataLoader implements CommandLineRunner {
	
	private ArtistRepository repo;
	
	@Autowired
	public ArtistsDataLoader(ArtistRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		this.repo.save(new Artist("Jorge", "Lopez"));
		/*this.repo.save(new Artist("Sal", "Mir"));
		this.repo.save(new Artist("Emily", "Knight"));
		this.repo.save(new Artist("Harriet", "Lunderbérg"));
		this.repo.save(new Artist("Linda", "Davidson"));
		this.repo.save(new Artist("Banksy", ""));*/

	}

}
