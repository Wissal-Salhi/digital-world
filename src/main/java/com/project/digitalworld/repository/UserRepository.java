package com.project.digitalworld.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.digitalworld.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public Optional<User> findByUsernameAndPass(String username, String pass);

}
