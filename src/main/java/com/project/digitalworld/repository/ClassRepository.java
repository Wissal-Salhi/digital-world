package com.project.digitalworld.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.digitalworld.entity.Class;

public interface ClassRepository extends JpaRepository<Class, Integer>  {

	public Optional<Class> findByName(String name);

}
