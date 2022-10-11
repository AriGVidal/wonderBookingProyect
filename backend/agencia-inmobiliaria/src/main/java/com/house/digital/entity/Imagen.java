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

import java.util.Objects;

@ApiModel("Modelo imagen")
@Entity
@Table(name = "imagen")
public class Imagen {
	
	@ApiModelProperty(value = "Id imagen")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ApiModelProperty(value = "Titulo imagen")
	@Column(name = "titulo", nullable = false)
	private String titulo;
	
	@ApiModelProperty(value = "Url imagen")
	@Column(name = "url", nullable = false)
	private String url;

	@ApiModelProperty(value = "Producto imagen")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "producto_id", referencedColumnName = "id")
	private Producto producto;

	public Imagen() {
	}

	public Imagen(String titulo, String url) {
		this.titulo = titulo;
		this.url = url;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Imagen imagen = (Imagen) o;
		return Objects.equals(id, imagen.id) &&
				Objects.equals(titulo, imagen.titulo) &&
				Objects.equals(url, imagen.url) &&
				Objects.equals(producto, imagen.producto);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, titulo, url, producto);
	}

	@Override
	public String toString() {
		return "Imagen{" +
				"id=" + id +
				", titulo='" + titulo + '\'' +
				", url='" + url + '\'' +
				", producto=" + producto +
				'}';
	}
}
