package com.project.digitalworld.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.project.digitalworld.entity.Class;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Data
public class Student extends User {

	 @JsonIgnore
	 @ManyToOne
	 @JoinColumn(name="class_id")
	 private Class c;
	
	private Integer score=0;
	

}
