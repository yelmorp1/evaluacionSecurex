package com.home.login.model;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class HttpResponse {

	private int httpStatusCode;
	private HttpStatus httpStatus;
	private String reason;
	private String message;
	
	public HttpResponse(int httpStatusCode, HttpStatus httpStatus, String reason, String message) {
		super();
		this.httpStatusCode = httpStatusCode;
		this.httpStatus = httpStatus;
		this.reason = reason;
		this.message = message;
	}

	public HttpResponse() {
		super();
	}
	
	
	
	
	
}
