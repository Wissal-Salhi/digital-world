package com.project.digitalworld.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.digitalworld.dto.SchoolAddDTO;
import com.project.digitalworld.dto.SchoolResponseDTO;
import com.project.digitalworld.entity.Manager;
import com.project.digitalworld.entity.School;
import com.project.digitalworld.entity.Student;
import com.project.digitalworld.entity.Teacher;
import com.project.digitalworld.entity.User;
import com.project.digitalworld.exceptionhandeling.BadRequestException;
import com.project.digitalworld.repository.SchoolRepository;
import com.project.digitalworld.service.SchoolService;

@Service
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	private SchoolRepository schoolRepository;
	
	@Autowired
	private ModelMapper modelmapper;

	
	
	@Override
	public List<School> findAll() {
		List<School> schools = schoolRepository.findAll();
		return schools;
	}


	@Override
	public SchoolResponseDTO findById(Integer id) throws BadRequestException {
		Optional<School> school = schoolRepository.findById(id);
		if (school.isEmpty())
			throw new BadRequestException("School not found - "+id);
		SchoolResponseDTO res= schoolToSchoolResponseDTO(school.get());
		return res;
	}

	@Override
	public SchoolResponseDTO findByName(String name) throws BadRequestException {
		Optional<School> school = schoolRepository.findByName(name);
		if (school.isEmpty())
			throw new BadRequestException("School not found - "+name);
		SchoolResponseDTO res= schoolToSchoolResponseDTO(school.get());
		return res;
	}

	@Override
	public void save(SchoolAddDTO schoolDTO) {
		School school = modelmapper.map(schoolDTO, School.class);
		schoolRepository.save(school);
	}
	
	@Override
	public void update(Integer id, SchoolAddDTO schoolDTO) throws BadRequestException {
		findById(id);
		School school = modelmapper.map(schoolDTO, School.class);
		school.setId(id);
		schoolRepository.save(school);
	}

	@Override
	public SchoolResponseDTO deleteById(Integer id) throws BadRequestException {
		SchoolResponseDTO school = findById(id);
		schoolRepository.deleteById(id);
		return school;
	}
	
	public SchoolResponseDTO schoolToSchoolResponseDTO (School s) {
		SchoolResponseDTO res= modelmapper.map(s, SchoolResponseDTO.class);
		for (User u: s.getUser()) {
			if (u.getRole().equals("student"))
				res.getStudents().add((Student)u);
			else if (u.getRole().equals("teacher"))
				res.getTeachers().add((Teacher)u);
			else if (u.getRole().equals("manager"))
				res.getManagers().add((Manager)u);
		}
		return res;
	}
}
