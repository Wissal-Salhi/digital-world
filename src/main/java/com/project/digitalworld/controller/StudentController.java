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

import com.project.digitalworld.dto.StudentAddDTO;
import com.project.digitalworld.exceptionhandeling.BadRequestException;
import com.project.digitalworld.exceptionhandeling.SuccessResponse;
import com.project.digitalworld.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("students")
public class StudentController {
	
	private static Logger log = LoggerFactory.getLogger(Slf4j.class);
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("")
	public ResponseEntity<SuccessResponse> addStudent(@Valid @RequestBody StudentAddDTO student) throws BadRequestException{
		
		log.info("calling method : addStudent()");
		studentService.save(student);
		SuccessResponse response= new SuccessResponse(student,System.currentTimeMillis());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
