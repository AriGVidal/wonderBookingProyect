package com.house.digital.service;

import com.house.digital.dto.CaracteristicaDto;
import com.house.digital.entity.Caracteristica;

import java.util.List;

public interface CaracteristicaService {
    CaracteristicaDto crearCaracteristica(Caracteristica caracteristicaD);

    CaracteristicaDto obtenerCaracteristicaPorId(Long id);
    
    List<CaracteristicaDto> obtenerCaracteristica();
}
