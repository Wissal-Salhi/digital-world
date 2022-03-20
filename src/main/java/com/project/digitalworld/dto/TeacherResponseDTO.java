package com.project.digitalworld.dto;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TeacherResponseDTO {
	
	private String username;
	
    private String firstName;
	
    private String lastName;
    
    private String avatar = "";
    
    private Date birthDate;
    
	private String gender;
	 
	private Boolean activated = true;
	
	private String role;
	 
	private Integer CIN;
	
}
