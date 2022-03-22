package com.project.digitalworld.exceptionhandeling;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.slf4j.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import lombok.extern.slf4j.Slf4j;



@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
	
	private static Logger log = LoggerFactory.getLogger(Slf4j.class);
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ExceptionResponse> handleResourceNotFound(BadRequestException e){

		log.warn("Calling Bad Request Exception handler");
		
		ExceptionResponse error= new ExceptionResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.add(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionResponse> handleValidationException(MethodArgumentNotValidException e){

		log.warn("Calling Method Argument Not Valid Exception handler");
		
		ExceptionResponse error= new ExceptionResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		BindingResult result = e.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();
		
		ArrayList<String> errorMesages = new ArrayList<>();
		for (FieldError err: fieldErrors  ) {
			String er= err.toString();
			errorMesages.add(er.substring((er.lastIndexOf("default message")+17),er.length()-1));
		}
		
		error.setMessages(errorMesages);
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ExceptionResponse> badRequestHandler(Exception e){
		
		log.warn("Calling Method Argument Type Mismatch Exception handler");

		
		ExceptionResponse error= new ExceptionResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.add("Must be a number");
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ExceptionResponse> handleNotreadableException(Exception e){
		
		log.warn("Calling Message Not Readable Exception handler");

		
		ExceptionResponse error= new ExceptionResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.add(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ExceptionResponse> handleConstraintViolationException(Exception e){
		
		log.warn("Calling Constraint Violation Exception handler");

		
		ExceptionResponse error= new ExceptionResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.add(e.getCause().getCause().getLocalizedMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}

	/*
	//ResponseEntity<ResponseDTO>
	//@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ExceptionResponse>  handleValidationExceptions(
			DataIntegrityViolationException	 e) {
		
		log.warn("Calling Data Integrity Violation Exception handler");
		
		/*
			Map<String, String> errors = new HashMap<>();
			ex.getBindingResult().getAllErrors().forEach((error) -> {
				String fieldName = ((FieldError) error).getField();
				String errorMessage = error.getDefaultMessage();
				errors.put(fieldName, errorMessage);
			});
			String message = errors.toString();
			message = message.replace("{","");
			message = message.replace("}","");
			
			return ResponseEntity
				.badRequest()
				.body(new ResponseDTO(message,
						"Validation errors",
						400));
		*/
	/*	ExceptionResponse error= new ExceptionResponse();
			
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.add(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST); 
	}
		*/
	
/*	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> handlebException(Exception e){

		ExceptionResponse error= new ExceptionResponse();
		
		log.warn("Calling  Exception handler");

		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.add(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
*/
}
