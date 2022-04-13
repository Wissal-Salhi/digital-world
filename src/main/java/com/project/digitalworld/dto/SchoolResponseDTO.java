package com.project.digitalworld.dto;

import java.util.ArrayList;
import java.util.List;

import com.project.digitalworld.entity.Manager;
import com.project.digitalworld.entity.Student;
import com.project.digitalworld.entity.Teacher;
import com.project.digitalworld.entity.Class;

import lombok.Data;

@Data
public class SchoolResponseDTO {

	private String name;
	
	private String adress;
	
	private String phoneNumber;
	
	private List<Student> students = new ArrayList<Student>();
	
	private List<Teacher> teachers = new ArrayList<Teacher>();
	
	private List<Manager> managers = new ArrayList<Manager>();
	
	private List<Class> classes = new ArrayList<Class>();
}
