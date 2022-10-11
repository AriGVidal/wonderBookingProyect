package com.house.digital.service;

import com.house.digital.dto.ReservaDTO;

import java.util.List;

public interface ReservaService {
    ReservaDTO crearReserva(ReservaDTO reservaDTO, String userName);
    List<ReservaDTO> reservasPorProducto(Long productId, String checkIn, String checkOut);
    List<ReservaDTO> reservasPorUsuario(String userName);
    ;
}
