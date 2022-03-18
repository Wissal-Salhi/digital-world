package com.project.digitalworld.entity;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Teacher extends User{
	
	private Integer CIN;
	
	

}
