package com.house.digital.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Dto login request")
public class LoginRequestDto {

	@ApiModelProperty(value = "Correo electrónico")
	private String email;
	
	@ApiModelProperty(value = "Contraseña")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
