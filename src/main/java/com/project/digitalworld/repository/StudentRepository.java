package com.project.digitalworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.digitalworld.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
