package com.project.digitalworld.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentResponseDTO {

	private String username;
	
    private String firstName;
	
    private String lastName;
    
    private String avatar = "";

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date birthDate;
    
	private String gender;
	 
	private Boolean activated = true;
	
	private String role;
	 
	private Integer score;
	
	private String schoolName;
	
	private String className;
}
