package com.RN.app.misc;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.RN.app.models.Orders;
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
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
		LocalDateTime time = LocalDateTime.now();
		User user = new User();
		
		Set<Orders> set = new HashSet<Orders>();
		set.add(new Orders(time, user));
		
		
		user.setUsername("admin123");
		user.setPassword(encoder.encode("123hello"));
		user.setEmail("someone@email.com");
		user.setOrders(set);
		
		this.repo.save(user);
	}

}
