package com.house.digital.entity;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ApiModel("Modelo ciudad")
@Entity
@Table(name = "ciudad")
public class Ciudad {
	
	@ApiModelProperty(value = "Id ciudad")
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@ApiModelProperty(value = "Nombre ciudad")
    @Column(name = "nombre", nullable = false)
    private String nombre;

	@ApiModelProperty(value = "País de la ciudad")
    @Column(name = "pais", nullable = false)
    private String pais;

	@ApiModelProperty(value = "Producto ciudad")
    @OneToMany(mappedBy = "ciudad", fetch = FetchType.LAZY)
    private List<Producto> productos;

    public Ciudad() {}

    public Ciudad(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
        this.productos = new ArrayList<>();
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
        Ciudad ciudad = (Ciudad) o;
        return Objects.equals(id, ciudad.id)
                && Objects.equals(nombre, ciudad.nombre)
                && Objects.equals(pais, ciudad.pais)
                && Objects.equals(productos, ciudad.productos);
    }


    @Override
    public String toString() {
        return "Ciudad{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", productos=" + productos +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, pais, productos);
    }


}

