package com.project.digitalworld.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.digitalworld.dto.StudentResponseDTO;
import com.project.digitalworld.dto.UserLoginDTO;
import com.project.digitalworld.entity.Student;
import com.project.digitalworld.entity.User;
import com.project.digitalworld.exceptionhandeling.BadRequestException;
import com.project.digitalworld.exceptionhandeling.SuccessResponse;
import com.project.digitalworld.repository.UserRepository;
import com.project.digitalworld.service.AuthService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("")
public class AuthController {

	private static Logger log = LoggerFactory.getLogger(Slf4j.class);
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/login")
	public ResponseEntity<SuccessResponse> login(@RequestBody UserLoginDTO userLoginDTO) throws BadRequestException {
		log.info("calling method : login()");
		SuccessResponse response = authService.login(userLoginDTO);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	
}
