package com.project.digitalworld.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.digitalworld.dto.ClassAddDTO;
import com.project.digitalworld.dto.SchoolResponseDTO;
import com.project.digitalworld.entity.Class;
import com.project.digitalworld.exceptionhandeling.BadRequestException;
import com.project.digitalworld.exceptionhandeling.SuccessResponse;
import com.project.digitalworld.service.ClassService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("classes")
public class ClassController {

	
	private static Logger log = LoggerFactory.getLogger(Slf4j.class);
	
	@Autowired
	private ClassService classService;
	
	@PostMapping("")
	public ResponseEntity<SuccessResponse> createClass(@Valid @RequestBody ClassAddDTO classDTO) throws Exception  {
	
		log.info("calling method : createClass()");
		classService.save(classDTO);
		SuccessResponse response= new SuccessResponse(classDTO,System.currentTimeMillis());
		return new ResponseEntity<>(response, HttpStatus.OK);
		}
	
	@GetMapping("/name/{className}")
	public ResponseEntity<SuccessResponse> findClassByName(@PathVariable String className) throws Exception {
		
		log.info("calling method : findClassByName()");
		Class c = classService.findByName(className);
		SuccessResponse response= new SuccessResponse(c,System.currentTimeMillis());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<SuccessResponse> findAllClasses() {
		log.info("calling method : findAllClasses()");
		List<Class> classes= classService.findAll();
		SuccessResponse response= new SuccessResponse(classes,System.currentTimeMillis());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/{classId}")
	public ResponseEntity<SuccessResponse> deleteClass(@Valid @PathVariable Integer classId) throws BadRequestException{
		log.info("calling method : deleteClass()");
		Class c = classService.deleteById(classId);	
		SuccessResponse response= new SuccessResponse(c,System.currentTimeMillis());
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
}
