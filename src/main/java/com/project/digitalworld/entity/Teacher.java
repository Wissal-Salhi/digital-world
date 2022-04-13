package com.project.digitalworld.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.digitalworld.entity.Class;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Teacher extends User{
	
	private Integer CIN;
	
	@JsonIgnore
	@OneToMany(mappedBy = "teacher",
 			cascade= CascadeType.ALL)
	private List<Class> classes;

}
