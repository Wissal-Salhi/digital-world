package com.project.digitalworld.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.digitalworld.dto.TeacherAddDTO;
import com.project.digitalworld.exceptionhandeling.BadRequestException;
import com.project.digitalworld.exceptionhandeling.SuccessResponse;
import com.project.digitalworld.service.TeacherService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("teachers")
public class TeacherController {

private static Logger log = LoggerFactory.getLogger(Slf4j.class);
	
	@Autowired
	private TeacherService teacherService;
	
	
	@PostMapping("")
	public ResponseEntity<SuccessResponse> addTeacher(@Valid @RequestBody TeacherAddDTO teacher) throws BadRequestException{
		log.info("calling method : addTeacher()");
		teacherService.save(teacher);
		SuccessResponse response= new SuccessResponse(teacher,System.currentTimeMillis());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
