package com.house.digital.service;

import com.house.digital.dto.PoliticaDTO;
import com.house.digital.dto.PoliticaGroupResponseDTO;
import com.house.digital.entity.Politica;

import java.util.List;

public interface PoliticaService {
    PoliticaDTO crearPolitica(Politica politica);
    List<PoliticaGroupResponseDTO> listaPoliticasPorProducto(Long productoId);
    List<PoliticaGroupResponseDTO> politicasPorNombre(List<PoliticaDTO>politicaDTOS);
    List<PoliticaDTO> getPoliticas(Long productoId);
}