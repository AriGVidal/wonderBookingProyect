package com.house.digital.mapper;

import com.house.digital.dto.ReservaDTO;
import com.house.digital.entity.Reserva;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservaMapper {
    List<ReservaDTO> listaReservaToReservaDTO(List<Reserva> listaReserva);
}
