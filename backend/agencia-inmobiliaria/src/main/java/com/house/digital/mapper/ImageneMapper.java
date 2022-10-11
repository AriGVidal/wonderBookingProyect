package com.house.digital.mapper;

import org.mapstruct.Mapper;

import com.house.digital.dto.ImagenDto;
import com.house.digital.entity.Imagen;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImageneMapper {

	ImagenDto imagenToImagenDto(Imagen imagen);

	List<Imagen> listImagenDtotoImagen(List<ImagenDto> listaImagenDTO);

	List<ImagenDto> listaImagenToImagenDTO(List<Imagen> listaImagen);


}
