package com.kiran.springboot.exception;

public class DoctorNotAvailableException extends RuntimeException {

	public DoctorNotAvailableException(String message) {
		super(message);
	}
}
