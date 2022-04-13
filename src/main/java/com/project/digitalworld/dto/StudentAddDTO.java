package com.project.digitalworld.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class StudentAddDTO {
	
	
	@NotBlank(message = "Username is mandatory")
	private String username;
	
	@NotBlank(message = "Firstname is mandatory")
    private String firstName;
	
    @NotBlank(message = "Lastname is mandatory")
    private String lastName;
    
    private String avatar = "";
    
    @NotNull(message = "Birth date is mandatory")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date birthDate;
    
    @NotBlank(message = "Password is mandatory")
	private String pass;
	
	@NotBlank(message = "Gender is mandatory")
	private String gender;
	
	@NotBlank(message = "School Name is mandatory")
	private String schoolName;
	
	@Pattern(regexp = "^[1-6]-.{1,}",
			 flags = Pattern.Flag.CASE_INSENSITIVE,
			 message="Class name must be level-name with level from 1 to 6. exp 1-A")
	@NotBlank(message = "Class Name is mandatory")
	private String className;
	 
	
}
