package com.house.digital.dto;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Modelo ciudad")
public class CiudadDto {

	@ApiModelProperty(value = "Id ciudad")
	private Long id;

	@ApiModelProperty(value = "Nombre ciudad")
	private String nombre;

	@ApiModelProperty(value = "País de la ciudad")
	private String pais;

	public CiudadDto() {
		super();
	}

	public CiudadDto(Long id, String nombre, String pais) {
		this.id = id;
		this.nombre = nombre;
		this.pais = pais;
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

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CiudadDto ciudadDto = (CiudadDto) o;
		return Objects.equals(id, ciudadDto.id) && Objects.equals(nombre, ciudadDto.nombre)
				&& Objects.equals(pais, ciudadDto.pais);
	}

	@Override
	public String toString() {
		return "City{" + "id=" + id + ", name='" + nombre + '\'' + ", country='" + pais + '\'' + '}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, pais);
	}
}
