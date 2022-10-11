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

@ApiModel("Modelo politica")
@Entity
@Table(name = "politica")
public class Politica {
	
	@ApiModelProperty(value = "Id politica")
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

	@ApiModelProperty(value = "Nombre politica")
    @Column(name = "nombre", nullable = false)
    private String nombre;

	@ApiModelProperty(value = "Descripción politica")
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

	@ApiModelProperty(value = "Producto politica")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    private Producto producto;

    public Politica() {
    }

    public Politica(String nombre, String descripcion) {
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
        Politica politica = (Politica) o;
        return Objects.equals(id, politica.id) &&
                Objects.equals(nombre, politica.nombre) &&
                Objects.equals(descripcion, politica.descripcion) &&
                Objects.equals(producto, politica.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, descripcion, producto);
    }

    @Override
    public String toString() {
        return "Politica{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", producto=" + producto +
                '}';
    }
}
