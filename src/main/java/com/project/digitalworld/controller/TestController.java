package com.project.digitalworld.controller;

import java.util.Date;

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
import com.project.digitalworld.utils.Gender;

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
		s.setUsername("wiss2");
		s.setPass("pass");
		s.setFirstName("wissal");
		s.setLastName("salhi");
		s.setBirthDate(new Date("7/18/1999"));
		s.setGender("female");
		s.setScore(9);
		s.setRole("student");
		studentRepository.save(s);
		
		Teacher t= new Teacher();
		t.setUsername("tess");
		t.setPass("pass");
		t.setFirstName("nawres");
		t.setLastName("salhi");
		t.setBirthDate(new Date("7/18/1991"));
		t.setGender("female");
		t.setCIN(99983);
		//teacherRepository.save(t);
		
		return ("<h1>Done</h1>");
	}
	
	@GetMapping("/all/{id}")
	public User get(@PathVariable Integer id ) {
		Student s= new Student();
		s.setUsername("test");
		s.setPass("pass");
		s.setScore(9);
		//userRepository.save(s);
		return userRepository.findById(id).get();
		//return ("<h1>deleted</h1>");
	}

}
