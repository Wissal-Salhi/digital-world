package com.project.digitalworld.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class School {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="name",length=20,unique=true)
	private String name;
	
	private String adress;
	
	private String phoneNumber;
	
	@JsonIgnore
	@OneToMany(mappedBy = "school",
 			cascade= CascadeType.ALL)
	private List<User> user;
	
	 
}
