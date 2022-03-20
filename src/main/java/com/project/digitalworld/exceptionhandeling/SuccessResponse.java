package com.project.digitalworld.exceptionhandeling;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SuccessResponse {
	
	

	private int status=200;
	private Object message;
	private long timeStamp;
	

	public SuccessResponse(Object message, long timeStamp) {
		this.message = message;
		this.timeStamp = timeStamp;
	}



	
}
