package com.project.digitalworld.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class ClassAddDTO {

	
	@NotBlank(message = "Class Name is mandatory")
	@Pattern(regexp = "^[1-6]-.{1,}",
	 flags = Pattern.Flag.CASE_INSENSITIVE,
	 message="Class name must be level-name with level from 1 to 6. exp 1-A")
	private String name;
	
	@NotBlank(message = "School Name is mandatory")
	private String schoolName;
	
	@NotNull(message="teacher id is mandatory")
	private Integer teacher_id;
	
	
}
