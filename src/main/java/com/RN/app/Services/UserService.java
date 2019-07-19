package com.RN.app.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RN.app.models.Role;
import com.RN.app.models.User;
import com.RN.app.repositories.RoleRepository;
import com.RN.app.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository userRepo;
	private RoleRepository roleRepo;
	
	@Autowired
	public UserService(UserRepository urepo, RoleRepository rrepo) {
		this.userRepo = urepo;
		this.roleRepo = rrepo;
	}
	
	public Boolean doesUsernameExist(String username) {
		User user = this.userRepo.findByUsername(username);
		
		if (user == null) {
			return false;
		}
		return true;
	}
	
	public Boolean doesEmailExist(String email) {
		User user = this.userRepo.findByEmail(email);
		
		if (user == null) {
			return false;
		}
		return true;
	}
	
	public User saveUser(User user) {
		return this.userRepo.save(user);
	}
	
	public Role saveRole(Role role) {
		return this.roleRepo.save(role);
	}
	
}
