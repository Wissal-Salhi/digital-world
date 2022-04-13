package com.project.digitalworld.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.digitalworld.dto.ClassAddDTO;
import com.project.digitalworld.entity.Class;
import com.project.digitalworld.entity.School;
import com.project.digitalworld.entity.Teacher;
import com.project.digitalworld.exceptionhandeling.BadRequestException;
import com.project.digitalworld.repository.ClassRepository;
import com.project.digitalworld.repository.SchoolRepository;
import com.project.digitalworld.repository.TeacherRepository;
import com.project.digitalworld.service.ClassService;

@Service
public class ClassServiceImpl implements ClassService {

	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
	private SchoolRepository schoolRepository;
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Override
	public void save(ClassAddDTO classDTO) throws Exception {
		Class c= modelmapper.map(classDTO, Class.class);
		Optional<School> s= schoolRepository.findByName(classDTO.getSchoolName());
		if (s.isEmpty())
			throw new BadRequestException("School not found - "+classDTO.getSchoolName());
		Optional<Teacher> teacher= teacherRepository.findById(classDTO.getTeacher_id());
		c.setSchool(s.get());
		if (teacher.isEmpty())
			throw new BadRequestException("Teacher not found - "+classDTO.getTeacher_id());
		c.setTeacher(teacher.get());
		classRepository.save(c);
	}
	
	@Override
	public List<Class> findAll() {
		List<Class> classes = classRepository.findAll();
		return classes;
	}
	
	@Override
	public Class findById(Integer id) throws BadRequestException {
		Optional<Class> c = classRepository.findById(id);
		if (c.isEmpty())
			throw new BadRequestException("class not found - "+id);
		return c.get();
	}
	
	@Override
	public Class findByName(String name) throws BadRequestException {
		Optional<Class> c = classRepository.findByName(name);
		if (c.isEmpty())
			throw new BadRequestException("class not found - "+name);
		return c.get();
	}
	
	@Override
	public Class deleteById(Integer id) throws BadRequestException {
		Class c = findById(id);
		classRepository.deleteById(id);
		return c;
	}

}
