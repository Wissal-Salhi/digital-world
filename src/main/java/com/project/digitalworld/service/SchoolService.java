package com.project.digitalworld.service;

import java.util.List;

import com.project.digitalworld.dto.SchoolAddDTO;
import com.project.digitalworld.dto.SchoolResponseDTO;
import com.project.digitalworld.entity.School;
import com.project.digitalworld.exceptionhandeling.BadRequestException;

public interface SchoolService {

	List<School> findAll();

	SchoolResponseDTO findById(Integer id) throws BadRequestException;

	void save(SchoolAddDTO schoolDTO);

	void update(Integer id, SchoolAddDTO schoolDTO) throws BadRequestException;

	SchoolResponseDTO deleteById(Integer id) throws BadRequestException;

	SchoolResponseDTO findByName(String name) throws BadRequestException;

}
