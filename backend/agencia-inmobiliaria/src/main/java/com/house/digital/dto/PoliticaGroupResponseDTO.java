package com.house.digital.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Dto grupo de politicas")
public class PoliticaGroupResponseDTO {

	@ApiModelProperty(value = "Nombre")
	private String nombre;

	@ApiModelProperty(value = "Descripción")
	private List<String> descripcion;

	public PoliticaGroupResponseDTO() {
	}

	public PoliticaGroupResponseDTO(String nombre, List<String> descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public List<String> getDescripcion() {
		return descripcion;
	}
}