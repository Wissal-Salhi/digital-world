package com.project.digitalworld.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class SchoolAddDTO {
	
	@NotBlank(message = "School name is mandatory")
	private String name;
	
	@NotBlank(message = "School adress is mandatory")
	private String adress;
	
	@NotBlank(message = "School phoneNumber is phoneNumber")
	@Pattern(regexp="[\\d]{8}",message = "School phoneNumber is 8 digits")
	private String phoneNumber;

}
