package com.project.digitalworld.service;


import javax.validation.Valid;

import com.project.digitalworld.dto.StudentRequestDTO;

public interface StudentService {

	void save(@Valid StudentRequestDTO student);

}
