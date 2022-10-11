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

import java.time.LocalDateTime;

@ApiModel("Modelo reserva")
@Entity
@Table(name = "reserva")
public class Reserva {
	
	@ApiModelProperty(value = "Id reserva")
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

	@ApiModelProperty(value = "Comprobante de entrada")
    @Column(name = "check_in", nullable = false)
    private LocalDateTime checkIn;

	@ApiModelProperty(value = "Comprobante de salida")
    @Column(name = "check_out", nullable = false)
    private LocalDateTime checkOut;

	@ApiModelProperty(value = "Producto reservado")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    private Producto producto;

	@ApiModelProperty(value = "Usuario que realiza reserva")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    public Reserva(){

    }

    public Reserva(LocalDateTime checkIn, LocalDateTime checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
