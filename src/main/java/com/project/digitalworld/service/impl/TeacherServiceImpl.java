package com.project.digitalworld.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.digitalworld.dto.TeacherAddDTO;
import com.project.digitalworld.entity.School;
import com.project.digitalworld.entity.Teacher;
import com.project.digitalworld.exceptionhandeling.BadRequestException;
import com.project.digitalworld.repository.SchoolRepository;
import com.project.digitalworld.repository.TeacherRepository;
import com.project.digitalworld.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository teacherRepository; 
	
	@Autowired
	private SchoolRepository schoolRepository; 
	
	@Autowired
	private ModelMapper modelmapper;
	
	public void save(TeacherAddDTO teacherDTO) throws BadRequestException {
		Optional<School> s = schoolRepository.findByName(teacherDTO.getSchoolName());
		if (s.isEmpty())
			throw new BadRequestException("School not found - "+teacherDTO.getSchoolName());
		Teacher teacher = modelmapper.map(teacherDTO, Teacher.class);
		teacher.setSchool(s.get());
		teacher.setRole("teacher");
		teacherRepository.save(teacher);
		
	}

}
