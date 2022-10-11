package com.house.digital.dto;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Dto categoria")
public class CategoriaDto {

	@ApiModelProperty(value = "Id categoria")
	private Long id;
	
	@ApiModelProperty(value = "Titulo categoria")
	private String titulo;
	
	@ApiModelProperty(value = "Descripcion categoria")
	private String descripcion;
	
	@ApiModelProperty(value = "Imagen categoria")
	private String imagen;

	public CategoriaDto() {
		super();
	}

	public CategoriaDto(Long id, String titulo, String descripcion, String imagen) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imagen = imagen;
	}

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CategoriaDto categoriaDto = (CategoriaDto) o;
		return Objects.equals(id, categoriaDto.id) && Objects.equals(titulo, categoriaDto.titulo) && Objects.equals(descripcion, categoriaDto.descripcion) && Objects.equals(imagen, categoriaDto.imagen);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, titulo, descripcion, imagen);
	}

}
