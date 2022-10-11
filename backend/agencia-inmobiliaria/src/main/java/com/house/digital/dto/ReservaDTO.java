package com.house.digital.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

@ApiModel("Dto reserva")
public class ReservaDTO {
	
	@ApiModelProperty(value = "Id reserva")
    private Long id;
	
	@ApiModelProperty(value = "Comprobante de entrada")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkIn;
	
	@ApiModelProperty(value = "Comprobante de salida")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkOut;
	
	@ApiModelProperty(value = "Producto reservado")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long productoId;

    public ReservaDTO() {
    }

    public ReservaDTO(Long id, LocalDateTime checkIn, LocalDateTime checkOut) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public ReservaDTO(Long id,LocalDateTime checkIn, LocalDateTime checkOut, Long productoId) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.productoId = productoId;
        this.id = id;

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

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }
}
