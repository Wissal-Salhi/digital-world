package com.project.digitalworld.service.impl;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.digitalworld.dto.StudentRequestDTO;
import com.project.digitalworld.entity.Student;
import com.project.digitalworld.repository.StudentRepository;
import com.project.digitalworld.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository; 
	
	@Autowired
	private ModelMapper modelmapper;

	public void save(StudentRequestDTO studentDTO) {
		
		Student student = modelmapper.map(studentDTO, Student.class);
		student.setRole("student");
		studentRepository.save(student);
	}

}
