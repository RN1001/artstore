package com.RN.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.RN.app.models.Artist;

public interface ArtistRepository extends CrudRepository<Artist, Long>{
	
}
