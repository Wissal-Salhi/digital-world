package com.project.digitalworld.exceptionhandeling;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponse {

	private int status;
	private ArrayList<String> messages=new ArrayList<>();
	private long timeStamp;
	
	
	
	public void add (String message) {
		messages.add(message);
	}
	
	
}
