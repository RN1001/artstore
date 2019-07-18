package com.RN.app.Auth;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.RN.app.models.Role;
import com.RN.app.models.User;
import com.RN.app.repositories.RoleRepository;
import com.RN.app.repositories.UserRepository;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
	
	private UserRepository userRepo;
	private RoleRepository roleRepo;
	
	public UserDetailsService(UserRepository userRepo, RoleRepository roleRepo) {
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("Could not find username");
		}
		
		ArrayList<Role> roles = this.roleRepo.findByUsername(username);
		
		return new UserPrincipal(user, roles);
	}

}
