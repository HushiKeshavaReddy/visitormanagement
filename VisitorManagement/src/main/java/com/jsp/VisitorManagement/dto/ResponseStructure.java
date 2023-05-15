package com.jsp.VisitorManagement.dto;

import java.time.LocalDateTime;

public class ResponseStructure<T>
{
	private Integer statuscode;
	
	private T data;
	
	private String message;
	
	private LocalDateTime timestamp;

	public Integer getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(Integer statuscode) {
		this.statuscode = statuscode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
