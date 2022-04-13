package com.project.digitalworld.service;


import com.project.digitalworld.dto.TeacherAddDTO;
import com.project.digitalworld.exceptionhandeling.BadRequestException;

public interface TeacherService {

	void save(TeacherAddDTO teacher) throws BadRequestException;

}
