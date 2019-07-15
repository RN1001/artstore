package com.RN.app.Auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.RN.app.models.User;
import com.RN.app.repositories.UserRepository;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
	
	private UserRepository userRepo;
	
	public UserDetailsService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("Could not find username");
		}
		
		return new UserPrincipal(user);
	}

}
