package com.project.digitalworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.digitalworld.entity.Student;
import com.project.digitalworld.entity.Teacher;
import com.project.digitalworld.entity.User;
import com.project.digitalworld.repository.StudentRepository;
import com.project.digitalworld.repository.TeacherRepository;
import com.project.digitalworld.repository.UserRepository;

@RestController
@RequestMapping("")
public class TestController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	@GetMapping("/admin")
	public String admin() {
		return ("<h1>Hi there admin</h1>");
	}
	
	@GetMapping("/teacher")
	public String teacher() {
		return ("<h1>Hi there teacher</h1>");
	}
	
	@GetMapping("/all")
	public String all() {
		Student s= new Student();
		s.setLogin("wiss");
		s.setPass("pass");
		s.setScore(9);
		studentRepository.save(s);
		
		Teacher t= new Teacher();
		t.setLogin("tess");
		t.setPass("pass");
		t.setCIN(99983);
		teacherRepository.save(t);
		
		return ("<h1>Done</h1>");
	}
	
	@GetMapping("/all/{id}")
	public User get(@PathVariable Integer id ) {
		Student s= new Student();
		s.setLogin("test");
		s.setPass("pass");
		s.setScore(9);
		//userRepository.save(s);
		return userRepository.findById(id).get();
		//return ("<h1>deleted</h1>");
	}

}
