package com.RN.app.misc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.RN.app.models.Role;
import com.RN.app.repositories.RoleRepository;

@Component
public class RoleDataLoader implements CommandLineRunner {
	
	private RoleRepository repo;
	
	@Autowired
	public RoleDataLoader(RoleRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public void run(String... args) throws Exception {
		this.repo.save(new Role("admin123", "USER"));
		this.repo.save(new Role("admin123", "ADMIN"));
	}
	
	
}

	
