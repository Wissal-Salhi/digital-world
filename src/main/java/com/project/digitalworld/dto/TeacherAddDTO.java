package com.project.digitalworld.dto;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class TeacherAddDTO {

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
	
	@NotBlank(message = "CIN is mandatory")
	@Pattern(regexp="[\\d]{8}",message = "CIN is 8 digits")
	private String CIN;
	
	@NotBlank(message = "School Name is mandatory")
	private String schoolName;
	
}
