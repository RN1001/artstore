package com.RN.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.RN.app.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
	boolean existsByUsername(String username);
	
}
