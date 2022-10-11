package com.house.digital.entity;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ApiModel("Modelo categoria")
@Entity
@Table(name = "categoria")
public class Categoria {

	@ApiModelProperty(value = "Id categoria")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@ApiModelProperty(value = "Titulo categoria")
	@Column(name = "titulo", nullable = false)
	private String titulo;

	@ApiModelProperty(value = "Descripcion categoria")
	@Column(name = "descripcion", nullable = false)
	private String descripcion;

	@ApiModelProperty(value = "Imagen categoria")
	@Column(name = "imagen", nullable = false)
	private String imagen;

	@ApiModelProperty(value = "Producto categoria")
	@OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Producto> productos;

	public Categoria() {
	}

	public Categoria(Long id, String titulo, String descripcion, String imagen) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.productos = new ArrayList<>();
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

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Categoria categoria = (Categoria) o;
		return Objects.equals(id, categoria.id) && Objects.equals(titulo, categoria.titulo)
				&& Objects.equals(descripcion, categoria.descripcion)
				&& Objects.equals(imagen, categoria.imagen)
				&& Objects.equals(productos, categoria.productos);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, titulo, descripcion, imagen, productos);
	}
}
