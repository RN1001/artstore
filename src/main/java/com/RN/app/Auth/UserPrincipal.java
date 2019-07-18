package com.RN.app.Auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.RN.app.models.Role;
import com.RN.app.models.User;

public class UserPrincipal implements UserDetails {

	private User user;
	private ArrayList<Role> roles;
	
	public UserPrincipal(User user, ArrayList<Role> roles) {
		this.user = user;
		this.roles = roles;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (roles == null) {
			Collections.emptySet();
		}
		Set<SimpleGrantedAuthority> grantedAuth = new HashSet<>();
		
		roles.forEach(role -> {
			grantedAuth.add(new SimpleGrantedAuthority(role.getRoleStatus()));
		});
		
		return grantedAuth;
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
	
}
