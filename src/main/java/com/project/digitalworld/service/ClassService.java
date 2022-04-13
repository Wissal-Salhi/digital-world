package com.project.digitalworld.service;



import java.util.List;

import com.project.digitalworld.dto.ClassAddDTO;
import com.project.digitalworld.entity.Class;
import com.project.digitalworld.exceptionhandeling.BadRequestException;

public interface ClassService {

	void save(ClassAddDTO classDTO) throws Exception;

	List<Class> findAll();

	Class findById(Integer id) throws BadRequestException;

	Class deleteById(Integer id) throws BadRequestException;

	Class findByName(String name) throws BadRequestException;
}
