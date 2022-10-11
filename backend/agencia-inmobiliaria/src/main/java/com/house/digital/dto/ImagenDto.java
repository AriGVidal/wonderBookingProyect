package com.house.digital.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Dto imagen")
public class ImagenDto {

	@ApiModelProperty(value = "Id imagen")
	private Long id;

	@ApiModelProperty(value = "Titulo imagen")
	private String titulo;

	@ApiModelProperty(value = "Url imagen")
	private String url;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
