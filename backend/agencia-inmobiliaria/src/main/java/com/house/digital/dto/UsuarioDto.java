package com.house.digital.dto;

import java.util.List;

import com.house.digital.entity.Reserva;
import com.house.digital.entity.Rol;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Dto usuario")
public class UsuarioDto {

	@ApiModelProperty(value = "Id usuario")
	private Long id;

	@ApiModelProperty(value = "Nombre usuario")
	private String nombre;

	@ApiModelProperty(value = "Apellido usuario")
	private String apellido;

	@ApiModelProperty(value = "Correo electrónico usuario")
	private String email;

	@ApiModelProperty(value = "Contraseña usuario")
	private String password;

	@ApiModelProperty(value = "Ciudad usuario")
	private String ciudad;

	@ApiModelProperty(value = "Rol usuario")
	private Rol rol;

	@ApiModelProperty(value = "Reservas usuario")
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
