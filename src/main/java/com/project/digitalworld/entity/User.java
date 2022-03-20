package com.project.digitalworld.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@NotBlank(message = "Username is mandatory")
	private String username;
	
	@NotBlank(message = "Firstname is mandatory")
    private String firstName;
	
    @NotBlank(message = "Lastname is mandatory")
    private String lastName;
    
    private String avatar = "";
    
    @NotNull(message = "Birth date is mandatory")
    private Date birthDate;
    
    @NotBlank(message = "Password is mandatory")
	private String pass;
	
	 @NotBlank(message = "Gender is mandatory")
	 private String gender;
	 
	 @JsonIgnore
	 private Boolean activated = true;
	
	 @NotBlank(message = "Role is mandatory")
	 @Pattern(regexp = "teacher|student|admin|manager",
			 flags = Pattern.Flag.CASE_INSENSITIVE,
			 message="Role must be in {teacher,student,admin,manager}")
	 private String role;
	

	    
}
