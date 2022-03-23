package com.project.digitalworld.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.digitalworld.dto.TeacherAddDTO;
import com.project.digitalworld.entity.Teacher;
import com.project.digitalworld.repository.TeacherRepository;
import com.project.digitalworld.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository teacherRepository; 
	
	@Autowired
	private ModelMapper modelmapper;
	
	public void save(TeacherAddDTO teacherDTO) {
		Teacher teacher = modelmapper.map(teacherDTO, Teacher.class);
		teacher.setRole("teacher");
		teacherRepository.save(teacher);
		
	}

}
