package com.house.digital.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.house.digital.dto.CategoriaDto;
import com.house.digital.entity.Categoria;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

	Categoria categoriaDtoToCategoria(CategoriaDto categoriaDto);
	
	CategoriaDto categoriaToCategoriaDto(Categoria categoria);

	List<CategoriaDto> listaCategoriaToListaCategoriaDto(List<Categoria> listaCategoria);
}
