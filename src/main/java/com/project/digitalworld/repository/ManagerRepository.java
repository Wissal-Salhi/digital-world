package com.project.digitalworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.digitalworld.entity.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {

}
