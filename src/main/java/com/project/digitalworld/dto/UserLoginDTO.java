package com.project.digitalworld.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserLoginDTO {
	
	@NotBlank(message = "Username is mandatory")
	private String username;
	
	@NotBlank(message = "password is mandatory")
	private String pass;

}
