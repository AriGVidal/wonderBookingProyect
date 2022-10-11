package com.house.digital.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Dto caracteristica")
public class CaracteristicaDto {

	@ApiModelProperty(value = "Id caracteristica")
	private Long id;

	@ApiModelProperty(value = "Nombre caracteristica")
	private String nombre;

	@ApiModelProperty(value = "Icono caracteristica")
	private String icono;

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

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}
}
