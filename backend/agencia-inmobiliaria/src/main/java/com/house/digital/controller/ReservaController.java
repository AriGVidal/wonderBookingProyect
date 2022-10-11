package com.house.digital.controller;

import com.house.digital.dto.ProductoDTO;
import com.house.digital.dto.ProductoPostDto;
import com.house.digital.dto.ReservaDTO;
import com.house.digital.service.ReservaService;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Servicio REST de reservas", description = "Gestión de los servicios de reservas")
@RestController
@RequestMapping("/api/reserva")
@CrossOrigin
public class ReservaController {
    private final ReservaService reservaService;

    @Autowired
    public ReservaController (ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping("/obtenerReservasPorProducto/{id}")
    public ResponseEntity<List<ReservaDTO>> obtenerReservaPorProducto(@PathVariable Long id,
                                                                      @RequestParam(name = "check_in", required = false) String checkIn,
                                                                      @RequestParam(name = "check_out", required = false) String checkOut) {
        return new ResponseEntity<>(this.reservaService.reservasPorProducto(id, checkIn, checkOut), HttpStatus.OK);

    }

    @PostMapping("/crear")
    public ResponseEntity<ReservaDTO> crearReserva(
            @RequestAttribute("username") String userName, @RequestBody ReservaDTO reservaDTO) {
        return new ResponseEntity<>(this.reservaService.crearReserva(reservaDTO, userName), HttpStatus.CREATED);
    }

    @GetMapping("/obtenerReservasPorUsuario")
    public ResponseEntity<List<ReservaDTO>> reservasPorUsuario(
            @RequestAttribute("username") String userName) {
        return new ResponseEntity<>(this.reservaService.reservasPorUsuario(userName), HttpStatus.OK);
    }
}
