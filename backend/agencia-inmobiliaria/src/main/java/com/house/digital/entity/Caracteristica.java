package com.house.digital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Modelo caracteristica")
@Entity
@Table(name = "caracteristica")
public class Caracteristica {

	@ApiModelProperty(value = "Id caracteristica")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@ApiModelProperty(value = "Nombre caracteristica")
	@Column(name = "nombre", nullable = false)
	private String nombre;

	@ApiModelProperty(value = "Icono caracteristica")
	@Column(name = "icono", nullable = false)
	private String icono;

	@ApiModelProperty(value = "Producto caracteristica")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "producto_id", referencedColumnName = "id")
	private Producto producto;

	public Caracteristica() {
	}

	public Caracteristica(String nombre, String icono) {
		this.nombre = nombre;
		this.icono = icono;
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

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
}
