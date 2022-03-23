package com.project.digitalworld.service.impl;


import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.digitalworld.dto.StudentAddDTO;
import com.project.digitalworld.entity.School;
import com.project.digitalworld.entity.Student;
import com.project.digitalworld.exceptionhandeling.BadRequestException;
import com.project.digitalworld.repository.SchoolRepository;
import com.project.digitalworld.repository.StudentRepository;
import com.project.digitalworld.service.SchoolService;
import com.project.digitalworld.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository; 
	
	@Autowired
	private SchoolService schoolService; 
	
	@Autowired
	private ModelMapper modelmapper;

	@Transactional(rollbackOn = BadRequestException.class)
	public void save(StudentAddDTO studentDTO) throws BadRequestException {
		School s = schoolService.findByName(studentDTO.getSchoolName());
		Student student = modelmapper.map(studentDTO, Student.class);
		student.setSchool(s);
		student.setRole("student");
		studentRepository.save(student);
	}

}
