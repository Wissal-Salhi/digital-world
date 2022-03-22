package com.project.digitalworld.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.digitalworld.entity.User;
import com.project.digitalworld.exceptionhandeling.SuccessResponse;
import com.project.digitalworld.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
public class UserController {

	private static Logger log = LoggerFactory.getLogger(Slf4j.class);
	
	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public ResponseEntity<SuccessResponse> findAllUsers() {

		log.info("calling method : findAllUsers()");
		
		List<User> users= userService.findAll();

		SuccessResponse response= new SuccessResponse(users,System.currentTimeMillis());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	
}
