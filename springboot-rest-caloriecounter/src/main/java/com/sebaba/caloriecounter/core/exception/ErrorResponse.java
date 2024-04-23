package com.sebaba.caloriecounter.core.exception;

import org.springframework.http.HttpStatus;

class ErrorResponse {

	private String message;
	private Throwable exception;
	private HttpStatus httpStatus;
	
	
	public ErrorResponse() {}

	public ErrorResponse(String message, HttpStatus httpStatus) {
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public ErrorResponse(String message, Throwable exception, HttpStatus httpStatus) {
		this.message = message;
		this.exception = exception;
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Throwable getException() {
		return exception;
	}
	
	public void setException(Throwable exception) {
		this.exception = exception;
	}
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
}