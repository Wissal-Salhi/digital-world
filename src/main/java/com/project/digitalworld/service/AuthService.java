package com.project.digitalworld.service;


import com.project.digitalworld.dto.UserLoginDTO;
import com.project.digitalworld.exceptionhandeling.BadRequestException;
import com.project.digitalworld.exceptionhandeling.SuccessResponse;

public interface AuthService {
	
	public SuccessResponse login(UserLoginDTO userLoginDTO) throws BadRequestException, Exception;

}
