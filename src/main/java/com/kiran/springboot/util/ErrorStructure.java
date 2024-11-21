package com.kiran.springboot.util;

public class ErrorStructure<T> { 
	
	private int statuscode;
	private String message;
	private T data;
	public int getStatuscode() {
		return statuscode;
	}
	public ErrorStructure<T> setStatuscode(int statuscode) {
		this.statuscode = statuscode;
		return this;
	}
	public String getMessage() {
		return message;
	}
	public ErrorStructure<T> setMessage(String message) {
		this.message = message;
		return this;
	}
	public T getData() {
		return data;
	}
	public ErrorStructure<T> setData(T data) {
		this.data = data;
		return this;
	}
}
