package com.project.digitalworld.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.project.digitalworld.entity.Class;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TeacherResponseDTO {
	
	private Integer id;
	
	private String username;
	
    private String firstName;
	
    private String lastName;
    
    private String avatar = "";
    
    private Date birthDate;
    
	private String gender;
	 
	private Boolean activated = true;
	
	private String role;
	 
	private Integer CIN;
	
	private List<String> classes;
	
}
