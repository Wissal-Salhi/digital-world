package com.project.digitalworld.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.digitalworld.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {


}
