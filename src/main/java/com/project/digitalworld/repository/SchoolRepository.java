package com.project.digitalworld.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.digitalworld.entity.School;
import com.project.digitalworld.entity.User;

public interface SchoolRepository extends JpaRepository<School, Integer> {
	
	public Optional<School> findByName(String name);

}
