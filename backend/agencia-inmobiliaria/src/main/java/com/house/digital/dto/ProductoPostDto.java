package com.house.digital.dto;

import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Dto producto post")
public class ProductoPostDto {

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
	
	@ApiModelProperty(value = "Ciudad producto")
    private Long idCiudad;
	
	@ApiModelProperty(value = "Categoría producto")
    private Long idCategoria;
	
	@ApiModelProperty(value = "Características producto")
    private List<CaracteristicaDto> caracteristicas;
	
	@ApiModelProperty(value = "Imágenes producto")
    private List<ImagenDto> imagenes;
	
	@ApiModelProperty(value = "Politicas producto")
    private List<PoliticaDTO> politicas;
	
	@ApiModelProperty(value = "Disponibilidad producto")
    private Boolean disponibilidad;

    public ProductoPostDto() {
    }

    public ProductoPostDto(Long id, String nombre, String descripcion, String titulo, String ubicacion, Long idCiudad, Long idCategoria, List<CaracteristicaDto>caracteristicas, List<ImagenDto> imagenes, List<PoliticaDTO> politicas) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.ubicacion = ubicacion;
        this.idCiudad = idCiudad;
        this.idCategoria = idCategoria;
        this.caracteristicas = caracteristicas;
        this.imagenes = imagenes;
        this.politicas = politicas;
        this.disponibilidad = true;
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

    public Long getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Long idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public List<CaracteristicaDto> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<CaracteristicaDto> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public List<ImagenDto> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<ImagenDto> imagenes) {
        this.imagenes = imagenes;
    }


    public List<PoliticaDTO> getPoliticas() {
        return politicas;
    }

    public void setPoliticas(List<PoliticaDTO> politicas) {
        this.politicas = politicas;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoPostDto that = (ProductoPostDto) o;
        return Objects.equals(id, that.id) && Objects.equals(nombre, that.nombre)
                && Objects.equals(descripcion, that.descripcion)
                && Objects.equals(titulo, that.titulo)
                && Objects.equals(ubicacion, that.ubicacion)
                && Objects.equals(idCategoria, that.idCategoria)
                && Objects.equals(idCiudad, that.idCiudad)
                && Objects.equals(caracteristicas, that.caracteristicas)
                && Objects.equals(imagenes, that.imagenes)
                && Objects.equals(disponibilidad, that.disponibilidad)
                && Objects.equals(politicas, that.politicas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, descripcion,titulo, ubicacion, idCategoria, idCiudad, caracteristicas, imagenes, politicas, disponibilidad);
    }

    @Override
    public String toString() {
        return "ProductoPostDto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", titulo='" + titulo + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", idCiudad=" + idCiudad +
                ", idCategoria=" + idCategoria +
                ", caracteristicas=" + caracteristicas +
                ", imagenes=" + imagenes +
                ", politicas=" + politicas +
                ", disponibilidad=" + disponibilidad +
                '}';
    }
}
