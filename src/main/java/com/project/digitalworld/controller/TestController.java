package com.project.digitalworld.controller;

import java.util.Date;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.digitalworld.dto.StudentResponseDTO;
import com.project.digitalworld.entity.Student;
import com.project.digitalworld.entity.Teacher;
import com.project.digitalworld.entity.User;
import com.project.digitalworld.repository.StudentRepository;
import com.project.digitalworld.repository.TeacherRepository;
import com.project.digitalworld.repository.UserRepository;


@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@GetMapping("/admin")
	public String admin() {
		return ("<h1>Hi there admin</h1>");
	}
	
	@GetMapping("/teacher")
	public String teacher() {
		return ("<h1>Hi there teacher</h1>");
	}
	
	@PostMapping("/users")
	public String createUser() {
		User u = new User();
		u.setUsername("user");
		u.setPass("pass");
		u.setFirstname("wissal");
		u.setLastname("salhi");
		u.setBirthdate(new Date("7/18/1999"));
		u.setGender("female");
		u.setRole("student");
		userRepository.save(u);
		return "saved";
	}
	
	@GetMapping("/all")
	public String all() {
		Student s= new Student();
		s.setUsername("wiss");
		s.setPass("pass");
		s.setFirstname("wissal");
		s.setLastname("salhi");
		s.setBirthdate(new Date("7/18/1999"));
		s.setGender("female");
		s.setScore(9);
		s.setRole("student");
		studentRepository.save(s);
		
		Teacher t= new Teacher();
		t.setUsername("tess");
		t.setPass("pass");
		t.setFirstname("nawres");
		t.setLastname("salhi");
		t.setBirthdate(new Date("7/18/1991"));
		t.setGender("female");
		t.setCIN(99983);
		t.setRole("teacher");
		teacherRepository.save(t);
		
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
	
	@GetMapping("/student/{id}")
	public StudentResponseDTO getStudent(@PathVariable Integer id ) {
		Student s= studentRepository.findById(id).get();
		StudentResponseDTO res=  modelmapper.map(s, StudentResponseDTO.class);
		return res;
	}

}
