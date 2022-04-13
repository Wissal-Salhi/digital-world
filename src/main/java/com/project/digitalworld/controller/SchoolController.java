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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.digitalworld.dto.SchoolAddDTO;
import com.project.digitalworld.dto.SchoolResponseDTO;
import com.project.digitalworld.entity.School;
import com.project.digitalworld.entity.Class;
import com.project.digitalworld.exceptionhandeling.BadRequestException;
import com.project.digitalworld.exceptionhandeling.SuccessResponse;
import com.project.digitalworld.service.SchoolService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("schools")
public class SchoolController {
	
	private static Logger log = LoggerFactory.getLogger(Slf4j.class);
	
	@Autowired
	private SchoolService schoolService;


	@GetMapping()
	public ResponseEntity<SuccessResponse> findAllSchools() {
		
		log.info("calling method : findAllSchools()");
		List<School> schools= schoolService.findAll();
		SuccessResponse response= new SuccessResponse(schools,System.currentTimeMillis());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/{schoolId}")
	public ResponseEntity<SuccessResponse> findSchoolById(@PathVariable Integer schoolId) throws Exception {
		
		log.info("calling method : findSchoolById()");
		SchoolResponseDTO school = schoolService.findById(schoolId);
		SuccessResponse response= new SuccessResponse(school,System.currentTimeMillis());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	@GetMapping("/name/{schoolName}")
	public ResponseEntity<SuccessResponse> findSchoolByName(@PathVariable String schoolName) throws Exception {
		
		log.info("calling method : findSchoolByName()");
		SchoolResponseDTO school = schoolService.findByName(schoolName);
		SuccessResponse response= new SuccessResponse(school,System.currentTimeMillis());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<SuccessResponse> createSchool(@Valid @RequestBody SchoolAddDTO schoolDTO)  {
	
		log.info("calling method : createSchool()");
		schoolService.save(schoolDTO);
		SuccessResponse response= new SuccessResponse(schoolDTO,System.currentTimeMillis());
		return new ResponseEntity<>(response, HttpStatus.OK);
		}
	
	
	
	@PutMapping("/{schoolId}")
	public ResponseEntity<SuccessResponse> updateSchool(
				@PathVariable Integer schoolId, 
				@Valid @RequestBody SchoolAddDTO schoolDTO) throws BadRequestException{

		log.info("calling method : updateSchool()");
		schoolService.update(schoolId, schoolDTO);
		SuccessResponse response= new SuccessResponse(schoolDTO,System.currentTimeMillis());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{schoolId}")
	public ResponseEntity<SuccessResponse> deleteSchool(@Valid @PathVariable Integer schoolId) throws BadRequestException{
		
		log.info("calling method : deleteSchool()");
		SchoolResponseDTO school = schoolService.deleteById(schoolId);	
		SuccessResponse response= new SuccessResponse(school,System.currentTimeMillis());
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}
