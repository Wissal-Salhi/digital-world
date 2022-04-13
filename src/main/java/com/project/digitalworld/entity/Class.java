package com.project.digitalworld.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Class {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	 private String name;
	
	 @JsonIgnore
	 @ManyToOne
	 @JoinColumn(name="school_id")
	 private School school;

	 
	 @OneToMany(mappedBy = "c",
	 			cascade= CascadeType.ALL)
		private List<Student> students;
	 
	
	 @ManyToOne
	 @JoinColumn(name="teacher_id")
	 private Teacher teacher;
}
