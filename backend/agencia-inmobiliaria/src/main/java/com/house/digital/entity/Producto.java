package com.house.digital.entity;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ApiModel("Modelo producto")
@Entity
@Table(name = "producto")
public class Producto {
	
	@ApiModelProperty(value = "Id producto")
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

	@ApiModelProperty(value = "Nombre producto")
    @Column(name = "nombre", nullable = false)
    private String nombre;

	@ApiModelProperty(value = "Descripción producto")
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

	@ApiModelProperty(value = "Titulo producto")
    @Column(name = "titulo", nullable = false)
    private String titulo;

	@ApiModelProperty(value = "Ubicación producto")
    @Column(name = "ubicacion", nullable = false)
    private String ubicacion;

	@ApiModelProperty(value = "Ciudad producto")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ciudad_id", referencedColumnName = "id", nullable = false)
    private Ciudad ciudad;

	@ApiModelProperty(value = "Categoría producto")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id", referencedColumnName = "id", nullable = false)
    private Categoria categoria;

	@ApiModelProperty(value = "Politicas producto")
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Politica> politicas;

	@ApiModelProperty(value = "Imágenes producto")
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Imagen> imagenes;

	@ApiModelProperty(value = "Características producto")
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Caracteristica> caracteristicas;

	@ApiModelProperty(value = "Reservas del producto")
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reserva> reservas;

    public Producto() {
    }

    public Producto(Long id, String nombre, String descripcion, String titulo, String ubicacion, Ciudad ciudad, Categoria categoria) {
        this(nombre, descripcion, titulo, ubicacion, ciudad, categoria);
        this.id = id;
    }

    public Producto(String nombre, String descripcion, String titulo, String ubicacion, Ciudad ciudad, Categoria categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.ubicacion = ubicacion;
        this.ciudad = ciudad;
        this.categoria = categoria;
        this.politicas = new ArrayList<>();
        this.caracteristicas = new ArrayList<>();
        this.imagenes = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    public List<Caracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<Caracteristica> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public List<Politica> getPoliticas() {
        return politicas;
    }

    public void setPoliticas(List<Politica> politicas) {
        this.politicas = politicas;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(id, producto.id) &&
                Objects.equals(nombre, producto.nombre) &&
                Objects.equals(descripcion, producto.descripcion) &&
                Objects.equals(titulo, producto.titulo) &&
                Objects.equals(ubicacion, producto.ubicacion) &&
                Objects.equals(ciudad, producto.ciudad) &&
                Objects.equals(categoria, producto.categoria) &&
                Objects.equals(politicas, producto.politicas) &&
                Objects.equals(imagenes, producto.imagenes) &&
                Objects.equals(reservas, producto.reservas) &&
                Objects.equals(caracteristicas, producto.caracteristicas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, descripcion, titulo, ubicacion, ciudad, categoria, politicas, imagenes, caracteristicas, reservas);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", titulo='" + titulo + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", ciudad=" + ciudad +
                ", categoria=" + categoria +
                ", politicas=" + politicas +
                ", imagenes=" + imagenes +
                ", caracteristicas=" + caracteristicas +
                ", reservas=" + reservas +
                '}';
    }
}


