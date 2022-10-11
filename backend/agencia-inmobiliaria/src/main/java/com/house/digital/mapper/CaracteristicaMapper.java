package com.house.digital.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.house.digital.dto.CaracteristicaDto;
import com.house.digital.entity.Caracteristica;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CaracteristicaMapper {
	
	CaracteristicaMapper INSTANCE = Mappers.getMapper(CaracteristicaMapper.class);

	CaracteristicaDto caracteristiasToCaracteristicasDto(Caracteristica caracteristica);

	List<Caracteristica> listCaracteristicaDtotoCaracteristica(List<CaracteristicaDto> caracteristicaDtoList);

	List<CaracteristicaDto> listCaracteristicatoCaracteristicaDTO(List<Caracteristica> caracteristicaist);



}
