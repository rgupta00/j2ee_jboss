package com.bookstore.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ErrorMessage implements Serializable{
	private String message;
	private String statusCode;
	private String toContact;
	private LocalDateTime dateTime;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getToContact() {
		return toContact;
	}
	public void setToContact(String toContact) {
		this.toContact = toContact;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorMessage(String message, String statusCode, String toContact, LocalDateTime dateTime) {
		super();
		this.message = message;
		this.statusCode = statusCode;
		this.toContact = toContact;
		this.dateTime = dateTime;
	}
	
	
	

}
