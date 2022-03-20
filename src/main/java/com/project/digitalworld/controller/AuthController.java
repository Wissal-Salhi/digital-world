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

import com.project.digitalworld.dto.UserLoginDTO;
import com.project.digitalworld.entity.User;
import com.project.digitalworld.exceptionhandeling.SuccessResponse;
import com.project.digitalworld.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("")
public class AuthController {

	private static Logger log = LoggerFactory.getLogger(Slf4j.class);
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/login")
	public ResponseEntity<SuccessResponse> login(@RequestBody UserLoginDTO userLoginDTO) {
		
		log.info("calling method : login()");
		
		User user= userRepository.findByUsernameAndPass(userLoginDTO.getUsername(), userLoginDTO.getPass());
		
		SuccessResponse response= new SuccessResponse(user,System.currentTimeMillis());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
