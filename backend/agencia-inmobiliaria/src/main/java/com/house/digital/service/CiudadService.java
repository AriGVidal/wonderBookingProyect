package com.house.digital.service;

import com.house.digital.dto.CiudadDto;

import java.util.List;

public interface CiudadService {

    CiudadDto crearCiudad(CiudadDto ciudadDto);

    List<CiudadDto> listarCiudades();

    CiudadDto obtenerCiudadPorId(Long id);

}
