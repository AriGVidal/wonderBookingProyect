package com.house.digital.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Dto politica")
public class PoliticaDTO {

	@ApiModelProperty(value = "Id politica")
	private Long id;

	@ApiModelProperty(value = "Nombre politica")
	private String nombre;

	@ApiModelProperty(value = "Descripción politica")
	private String descripcion;

	public PoliticaDTO() {

	}

	public PoliticaDTO(Long id, String nombre, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
