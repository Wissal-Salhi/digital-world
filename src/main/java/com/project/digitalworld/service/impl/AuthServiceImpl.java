package com.project.digitalworld.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.digitalworld.dto.StudentResponseDTO;
import com.project.digitalworld.dto.UserLoginDTO;
import com.project.digitalworld.entity.Student;
import com.project.digitalworld.entity.User;
import com.project.digitalworld.exceptionhandeling.BadRequestException;
import com.project.digitalworld.exceptionhandeling.SuccessResponse;
import com.project.digitalworld.repository.UserRepository;
import com.project.digitalworld.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	UserRepository userRepository;
	
	
	public User findByUsernameAndPass (String name, String pass) throws BadRequestException {
		
		Optional<User> user = userRepository.findByUsernameAndPass(name,pass);

		if (user.isEmpty()) {
			throw new BadRequestException("User not found");
		}
		
		return user.get();
	}
	
	
	
	@Override
	public SuccessResponse login(UserLoginDTO userLoginDTO) throws BadRequestException {
		
		User user= findByUsernameAndPass(userLoginDTO.getUsername(), userLoginDTO.getPass());
		SuccessResponse response= new SuccessResponse();
		
		if (user.getRole().equals("student")) {
			//add object mapper
			Student st= (Student) user;
			StudentResponseDTO s = new StudentResponseDTO();
			s.setUsername(user.getUsername());
			s.setGender(user.getGender());
			s.setScore(st.getScore());
			response.setMessage(s);
			
		}else if (user.getRole().equals("teacher")) {
			System.out.println("teacher");
		}else if (user.getRole().equals("manager")) {
			System.out.println("manager");
		}else if (user.getRole().equals("admin")) {
			System.out.println("admin");
		}
		
		return null;
	}

}
