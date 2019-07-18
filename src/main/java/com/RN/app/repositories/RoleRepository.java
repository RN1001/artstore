package com.RN.app.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.RN.app.models.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	ArrayList<Role> findByUsername(String username);
}
