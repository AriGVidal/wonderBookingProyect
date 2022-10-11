package com.house.digital.mapper;
import com.house.digital.dto.CiudadDto;
import com.house.digital.entity.Ciudad;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CiudadMapper {

    Ciudad ciudadDtoToCiudad(CiudadDto ciudadDto);

    CiudadDto ciudadToCiudadDto(Ciudad ciudad);

    List<CiudadDto> listCiudadToListCiudadDto(List<Ciudad> ciudadList);
}

