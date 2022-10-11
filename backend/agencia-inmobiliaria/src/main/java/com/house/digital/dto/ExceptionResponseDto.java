package com.house.digital.dto;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Dto exception response")
public class ExceptionResponseDto {
	
	@ApiModelProperty(value = "Hora de la excepción")
	private String timestamp;
	
	@ApiModelProperty(value = "Status de la excepción")
	private String status;
	
	@ApiModelProperty(value = "Código del status")
	private String error;
	
	@ApiModelProperty(value = "Mensaje de la excepción")
	private String message;
	
	@ApiModelProperty(value = "URL de la petición")
	private String path;
	
	public ExceptionResponseDto() {
		
	}

	public ExceptionResponseDto(String status, String error, String message, String path) {
		super();
		this.timestamp = LocalDateTime.now().toString();
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "ExceptionResponseDto [timestamp=" + timestamp + ", status=" + status + ", error=" + error + ", message="
				+ message + ", path=" + path + "]";
	}
	
}