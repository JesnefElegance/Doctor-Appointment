package com.kiran.springboot.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.kiran.springboot.exception.DoctorNotAvailableException;

@RestControllerAdvice
public class ApplicationHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> doctorNotAvailable(DoctorNotAvailableException e) {
		
		ErrorStructure<String> st = new ErrorStructure<String>();
		st.setStatuscode(HttpStatus.NOT_FOUND.value())
		  .setMessage(e.getMessage())
		  .setData("Doctor not found");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(st);
	}
}
