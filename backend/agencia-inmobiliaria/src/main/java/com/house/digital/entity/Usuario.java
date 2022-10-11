package com.house.digital.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("Modelo usuario")
@Entity
@Table(name = "usuario")
public class Usuario {

	@ApiModelProperty(value = "Id usuario")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ApiModelProperty(value = "Nombre usuario")
	@Column(name = "nombre")
	private String nombre;

	@ApiModelProperty(value = "Apellido usuario")
	@Column(name = "apellido")
	private String apellido;

	@ApiModelProperty(value = "Correo electrónico usuario")
	@Column(name = "email")
	private String email;

	@ApiModelProperty(value = "Contraseña usuario")
	@Column(name = "password")
	private String password;

	@ApiModelProperty(value = "Ciudad usuario")
	@Column(name = "ciudad")
	private String ciudad;

	@ApiModelProperty(value = "Rol usuario")
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_rol", nullable = false, foreignKey = @ForeignKey(name = "FK_Rol"))
	private Rol rol;

	@ApiModelProperty(value = "Reservas usuario")
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Reserva> reservas;

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

}
