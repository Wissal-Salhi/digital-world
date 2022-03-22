package com.project.digitalworld.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.digitalworld.dto.AdminResponseDTO;
import com.project.digitalworld.dto.ManagerResponseDTO;
import com.project.digitalworld.dto.StudentResponseDTO;
import com.project.digitalworld.dto.TeacherResponseDTO;
import com.project.digitalworld.dto.UserLoginDTO;
import com.project.digitalworld.entity.Admin;
import com.project.digitalworld.entity.Manager;
import com.project.digitalworld.entity.Student;
import com.project.digitalworld.entity.Teacher;
import com.project.digitalworld.entity.User;
import com.project.digitalworld.exceptionhandeling.BadRequestException;
import com.project.digitalworld.exceptionhandeling.SuccessResponse;
import com.project.digitalworld.repository.UserRepository;
import com.project.digitalworld.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelmapper;
	
	
	public User findByUsernameAndPass (String name, String pass) throws BadRequestException {
		
		Optional<User> user = userRepository.findByUsernameAndPass(name,pass);

		if (user.isEmpty()) {
			throw new BadRequestException("User not found");
		}
		
		return user.get();
	}
	
	
	
	@Override
	public SuccessResponse login(UserLoginDTO userLoginDTO) throws Exception {
		
		User user= findByUsernameAndPass(userLoginDTO.getUsername(), userLoginDTO.getPass());
		SuccessResponse response= new SuccessResponse();
		
		
		if (user.getRole().equals("student")) {
			
			Student s= (Student) user;
			StudentResponseDTO res = modelmapper.map(s, StudentResponseDTO.class);
			response.setMessage(res);
			
		}else if (user.getRole().equals("teacher")) {
			
			Teacher t= (Teacher) user;
			TeacherResponseDTO res = modelmapper.map(t, TeacherResponseDTO.class);
			response.setMessage(res);
			
		}else if (user.getRole().equals("manager")) {

			Manager m= (Manager) user;
			ManagerResponseDTO res = modelmapper.map(m, ManagerResponseDTO.class);
			response.setMessage(res);
			
		}else if (user.getRole().equals("admin")) {

			Admin a= (Admin) user;
			AdminResponseDTO res = modelmapper.map(a, AdminResponseDTO.class);
			response.setMessage(res);
			
		}else {
			throw new Exception("User has no Role");
		}
		
		response.setTimeStamp(System.currentTimeMillis());
		return response;
	}

}
