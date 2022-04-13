package com.project.digitalworld.service.impl;


import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.digitalworld.dto.StudentAddDTO;
import com.project.digitalworld.entity.School;
import com.project.digitalworld.entity.Class;
import com.project.digitalworld.entity.Student;
import com.project.digitalworld.exceptionhandeling.BadRequestException;
import com.project.digitalworld.repository.ClassRepository;
import com.project.digitalworld.repository.SchoolRepository;
import com.project.digitalworld.repository.StudentRepository;
import com.project.digitalworld.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository; 
	
	@Autowired
	private SchoolRepository schoolRepository; 
	
	@Autowired
	private ClassRepository classRepository; 
	
	@Autowired
	private ModelMapper modelmapper;

	@Transactional(rollbackOn = BadRequestException.class)
	public void save(StudentAddDTO studentDTO) throws BadRequestException {
		Optional<School> s = schoolRepository.findByName(studentDTO.getSchoolName());
		if (s.isEmpty())
			throw new BadRequestException("School not found - "+studentDTO.getSchoolName());
		Optional<Class> c = classRepository.findByName(studentDTO.getClassName());
		if (c.isEmpty())
			throw new BadRequestException("Class not found - "+studentDTO.getClassName());
		Student student = modelmapper.map(studentDTO, Student.class);
		student.setSchool(s.get());
		student.setC(c.get());
		student.setRole("student");
		studentRepository.save(student);
	}

}
