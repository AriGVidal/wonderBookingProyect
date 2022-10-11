package com.house.digital.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Dto producto")
public class ProductoDTO {

	@ApiModelProperty(value = "Id producto")
	private Long id;

	@ApiModelProperty(value = "Nombre producto")
	private String nombre;

	@ApiModelProperty(value = "Descripción producto")
	private String descripcion;

	@ApiModelProperty(value = "Titulo producto")
	private String titulo;

	@ApiModelProperty(value = "Ubicación producto")
	private String ubicacion;

	@ApiModelProperty(value = "Categoría producto")
	private CategoriaDto categoria;

	@ApiModelProperty(value = "Ciudad producto")
	private CiudadDto ciudad;

	@ApiModelProperty(value = "Politicas producto")
	private List<PoliticaDTO> politicas;

	@ApiModelProperty(value = "Imágenes producto")
	private List<ImagenDto> imagenes;

	@ApiModelProperty(value = "Características producto")
	private List<CaracteristicaDto> caracteristicas;

	@ApiModelProperty(value = "Reservas del producto")
	private List<ReservaDTO> reservas;

	public ProductoDTO() {

	}

	public ProductoDTO(Long id, String nombre, String descripcion, String titulo, String ubicacion,
			CategoriaDto categoria, CiudadDto ciudad, List<PoliticaDTO> politicas, List<ImagenDto> imagenes,
			List<CaracteristicaDto> caracteristicas, List<ReservaDTO> reservas) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.titulo = titulo;
		this.ubicacion = ubicacion;
		this.politicas = politicas;
		this.categoria = categoria;
		this.ciudad = ciudad;
		this.imagenes = imagenes;
		this.caracteristicas = caracteristicas;
		this.reservas = reservas;
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

	public CategoriaDto getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDto categoria) {
		this.categoria = categoria;
	}

	public CiudadDto getCiudad() {
		return ciudad;
	}

	public void setCiudad(CiudadDto ciudad) {
		this.ciudad = ciudad;
	}

	public List<PoliticaDTO> getPoliticas() {
		return politicas;
	}

	public void setPoliticas(List<PoliticaDTO> politicas) {
		this.politicas = politicas;
	}

	public List<ImagenDto> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<ImagenDto> imagenes) {
		this.imagenes = imagenes;
	}

	public List<CaracteristicaDto> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(List<CaracteristicaDto> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public List<ReservaDTO> getReservas() {
		return reservas;
	}

	public void setReservas(List<ReservaDTO> reservas) {
		this.reservas = reservas;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
}
