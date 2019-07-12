package com.RN.app.misc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.RN.app.models.User;
import com.RN.app.repositories.UserRepository;

@Component
public class UserDataLoader implements CommandLineRunner {
	
	private UserRepository repo;
	
	@Autowired
	public UserDataLoader(UserRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public void run(String... args) throws Exception {
		this.repo.save(new User("admin", "admin", 1));
	}

}
