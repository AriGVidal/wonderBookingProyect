package com.house.digital.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Dto rol")
public class RolDto {

	@ApiModelProperty(value = "Id rol")
	private Long id;
	
	@ApiModelProperty(value = "Nombre rol")
	private String nombre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
