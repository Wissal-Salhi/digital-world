package com.project.digitalworld.service;

import com.project.digitalworld.dto.StudentAddDTO;
import com.project.digitalworld.exceptionhandeling.BadRequestException;

public interface StudentService {

	void save(StudentAddDTO student) throws BadRequestException;

}
